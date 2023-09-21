package com.litao.coupon.customer.feign.fallback;

import com.litao.coupon.customer.feign.TemplateService;
import com.litao.coupon.template.api.beans.CouponTemplateInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;


@Slf4j
@Component
public class TemplateServiceFallback implements TemplateService {
    @Override
    public CouponTemplateInfo getTemplate(Long id) {
        log.info("根据id获取优惠券模板降级逻辑");
        return null;
    }

    @Override
    public Map<Long, CouponTemplateInfo> getTemplateInBatch(Collection<Long> ids) {
        log.info("批量获取优惠卷模板");
        return null;
    }
}
