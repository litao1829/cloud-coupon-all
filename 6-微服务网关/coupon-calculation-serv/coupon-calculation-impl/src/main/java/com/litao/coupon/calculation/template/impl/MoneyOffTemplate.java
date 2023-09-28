package com.litao.coupon.calculation.template.impl;

import com.litao.coupon.calculation.template.AbstractRuleTemplate;
import com.litao.coupon.calculation.template.RuleTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author mqxu
 * @date 2023/9/8
 * @description MoneyOffTemplate——满减优惠券
 **/
@Slf4j
@Component
public class MoneyOffTemplate extends AbstractRuleTemplate implements RuleTemplate {

    @Override
    protected Long calculateNewPrice(Long totalAmount, Long shopAmount, Long quota) {
        // benefitAmount 是扣减的价格
        // 如果当前门店的商品总价 < quota，那么最多只能扣减 shopAmount 的钱数
        Long benefitAmount = shopAmount < quota ? shopAmount : quota;
        return totalAmount - benefitAmount;
    }
}
