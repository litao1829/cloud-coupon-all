package com.litao.coupon.customer.feign;

import com.litao.coupon.calculation.api.beans.ShoppingCart;
import com.litao.coupon.calculation.api.beans.SimulationOrder;
import com.litao.coupon.calculation.api.beans.SimulationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "coupon-calculation-serv",path = "/calculator")
public interface CalculationService {

    /**
     * 优惠卷结算
     * @param shoppingCart
     * @return
     */
    @PostMapping("/checkout")
    ShoppingCart  checkout(ShoppingCart shoppingCart);

    @PostMapping("/simulate")
    SimulationResponse simulate(SimulationOrder simulationOrder);
}
