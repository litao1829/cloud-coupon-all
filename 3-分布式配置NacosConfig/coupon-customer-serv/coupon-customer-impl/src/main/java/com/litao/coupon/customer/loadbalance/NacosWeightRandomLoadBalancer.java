package com.litao.coupon.customer.loadbalance;

import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.nacos.client.naming.utils.Chooser;
import com.alibaba.nacos.client.naming.utils.Pair;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.DefaultResponse;
import org.springframework.cloud.client.loadbalancer.EmptyResponse;
import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.cloud.loadbalancer.core.NoopServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import reactor.core.publisher.Mono;

/**
 * @author mqxu
 * @date 2023/9/15
 * @description NacosWeightRandomLoadBalancer
 **/
public class NacosWeightRandomLoadBalancer implements ReactorServiceInstanceLoadBalancer {

    private static final Log log = LogFactory.getLog(NacosWeightRandomLoadBalancer.class);

    private final ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider;

    private final String serviceId;

    /**
     * @param serviceInstanceListSupplierProvider The provider of
     */
    public NacosWeightRandomLoadBalancer(
            ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider,
            String serviceId) {
        this.serviceId = serviceId;
        this.serviceInstanceListSupplierProvider = serviceInstanceListSupplierProvider;
    }

    @Override
    public Mono<Response<ServiceInstance>> choose(Request request) {
        ServiceInstanceListSupplier supplier = serviceInstanceListSupplierProvider
                .getIfAvailable(NoopServiceInstanceListSupplier::new);
        return supplier.get().next().map(this::getInstanceResponse);
    }

    private Response<ServiceInstance> getInstanceResponse(
            List<ServiceInstance> instances) {
        if (instances.isEmpty()) {
            log.warn("No servers available for service: " + this.serviceId);
            return new EmptyResponse();
        }

        ServiceInstance instance = getHostByRandomWeight(instances);

        return new DefaultResponse(instance);
    }

    /**
     * Return one {@link ServiceInstance} from the host list by random-weight.
     *
     * @param serviceInstances The list of the instance.
     * @return The random-weight result of the instance.
     */
    protected ServiceInstance getHostByRandomWeight(
            List<ServiceInstance> serviceInstances) {
        log.debug("entry randomWithWeight");
        if (serviceInstances == null || serviceInstances.isEmpty()) {
            log.debug("serviceInstances == null || serviceInstances.size() == 0");
            return null;
        }

        Chooser<String, ServiceInstance> instanceChooser = new Chooser<>(
                "top.mqxu");

        List<Pair<ServiceInstance>> hostsWithWeight = serviceInstances.stream()
                .map(serviceInstance -> new Pair<>(serviceInstance,
                        getWeight(serviceInstance)))
                .collect(Collectors.toList());

        instanceChooser.refresh(hostsWithWeight);
        log.debug("refresh instanceChooser");
        return instanceChooser.randomWithWeight();
    }

    /**
     * Get {@link ServiceInstance} weight metadata.
     *
     * @param serviceInstance instance
     * @return The weight of the instance.
     */
    protected double getWeight(ServiceInstance serviceInstance) {
        return Double.parseDouble(serviceInstance.getMetadata().get("nacos.weight"));
    }
}