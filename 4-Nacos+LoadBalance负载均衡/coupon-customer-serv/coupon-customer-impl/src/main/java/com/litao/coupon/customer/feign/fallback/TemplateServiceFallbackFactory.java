package com.litao.coupon.customer.feign.fallback;

import com.litao.coupon.customer.feign.TemplateService;
import com.litao.coupon.template.api.beans.CouponTemplateInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;


@Slf4j
@Component
public class TemplateServiceFallbackFactory implements FallbackFactory<TemplateService> {

    @Override
    public TemplateService create(Throwable cause) {
        return new TemplateService(){
            @Override
            @HystrixCommand(fallbackMethod = "fallbackMethod")
            public CouponTemplateInfo getTemplate(Long id) {
                log.info("fallback factory method:"+cause);
                return null;
            }

            @Override
            @HystrixCommand(fallbackMethod = "fallbackMethod")
            public Map<Long, CouponTemplateInfo> getTemplateInBatch(Collection<Long> ids) {
                log.info("fallback factory method:"+cause);
                return null;
            }
        };
    }
}
