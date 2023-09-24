package com.litao.coupon.customer.feign.fallback;

import com.litao.coupon.customer.feign.TemplateService;
import com.litao.coupon.template.api.beans.CouponTemplateInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@Component
public class TemplateServiceFallbackFactory implements FallbackFactory<TemplateService> {

    @Override
    public TemplateService create(Throwable cause) {
        return new TemplateService(){
            @Override
            public CouponTemplateInfo getTemplate(Long id) {
                log.info("根据id获取优惠券模板降级逻辑"+cause);
                return CouponTemplateInfo.builder().id(123L).name("降级优惠卷").desc("一张降级优惠").type("折扣").shopId(123L).rule(null).available(true).build();
            }

            @Override
            public Map<Long, CouponTemplateInfo> getTemplateInBatch(Collection<Long> ids) {
                log.info("批量获取优惠卷模板降级逻辑"+cause);
                Map<Long, CouponTemplateInfo> map=new HashMap<>();
                map.put(1L,CouponTemplateInfo.builder().id(123L).name("降级优惠卷").desc("一张降级优惠").type("折扣").shopId(123L).rule(null).available(true).build());
                return map;
            }
        };
    }
}
