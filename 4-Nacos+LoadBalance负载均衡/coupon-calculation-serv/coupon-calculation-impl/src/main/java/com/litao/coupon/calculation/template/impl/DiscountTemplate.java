package com.litao.coupon.calculation.template.impl;

import com.litao.coupon.calculation.template.AbstractRuleTemplate;
import com.litao.coupon.calculation.template.RuleTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DiscountTemplate extends AbstractRuleTemplate implements RuleTemplate {
    @Override
    protected Long calculateNewPrice(Long orderTotalAmount, Long shopTotalAmount, Long quota) {
        //计算使用优惠券之后的价格
        Long newPrice =convertToDecimal(shopTotalAmount *(quota.doubleValue()/100));
        log.debug("original price={},new price={}",orderTotalAmount,newPrice);
        return newPrice;
    }
}
