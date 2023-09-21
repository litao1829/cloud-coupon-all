package com.litao.coupon.calculation.api.beans;

import com.google.common.collect.Maps;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * 试运算优惠返回结果
 */
@Data
@NoArgsConstructor
public class SimulationResponse {

    /**
     * 最省钱的coupon id
     */
    private Long bestCouponId;


    /**
     * 每一个coupon对应的order价格
     */
    private Map<Long,Long> couponToOrderPrice = Maps.newHashMap();

}
