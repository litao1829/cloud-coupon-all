package com.litao.coupon.template.api.beans.rules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 优惠卷模板规则
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemplateRule {

    /**
     * 可以享受的折扣
     */
    private Discount discount;

    /**
     *每个人最多领到此优惠卷的数量
     */
    private Integer limitation;

    /**
     * 过期时间
     */
    private Long deadline;
}
