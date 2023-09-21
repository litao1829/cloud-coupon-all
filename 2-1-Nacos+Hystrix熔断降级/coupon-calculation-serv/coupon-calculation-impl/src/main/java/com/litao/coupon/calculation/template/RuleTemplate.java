package com.litao.coupon.calculation.template;

import com.litao.coupon.calculation.api.beans.ShoppingCart;

/**
 * 模板规则接口
 */
public interface RuleTemplate {
    /**
     * 计算优惠卷
     * @param settlement
     * @return
     */
    ShoppingCart calculate(ShoppingCart settlement);
}
