package com.litao.coupon.calculation.service;

import com.litao.coupon.calculation.api.beans.ShoppingCart;
import com.litao.coupon.calculation.api.beans.SimulationOrder;
import com.litao.coupon.calculation.api.beans.SimulationResponse;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * CouponCalculationService
 */

public interface CouponCalculationService {
    /**
     * 订单价格计算
     * @param cart 购物车
     * @return 计算结果
     */
    ShoppingCart calculationOrderPrice(@RequestBody ShoppingCart cart);


    /**
     * 订单价格试算
     * @param cart 购物车
     * @return 试算结果
     */
    SimulationResponse simulateOrder(@RequestBody SimulationOrder order);
}
