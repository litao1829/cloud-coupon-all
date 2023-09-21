package com.litao.coupon.calculation.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.litao.coupon.calculation.api.beans.ShoppingCart;
import com.litao.coupon.calculation.api.beans.SimulationOrder;
import com.litao.coupon.calculation.api.beans.SimulationResponse;
import com.litao.coupon.calculation.service.CouponCalculationService;
import com.litao.coupon.calculation.template.CouponTemplateFactory;
import com.litao.coupon.calculation.template.RuleTemplate;
import com.litao.coupon.template.api.beans.CouponInfo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Service
public class CouponCalculationServiceImpl implements CouponCalculationService {
    @Resource
    private CouponTemplateFactory couponTemplateFactory;


    /**
     * 优惠券结算，这里通过Factory类决定使用哪个底层Rule，底层规则对上层透明
     * @param cart 购物车
     * @return
     */
    @Override
    public ShoppingCart calculationOrderPrice(@RequestBody ShoppingCart cart) {
        log.info("calculate order price:{}", JSON.toJSONString(cart));
        RuleTemplate ruleTemplate= couponTemplateFactory.getTemplate(cart);
        return ruleTemplate.calculate(cart);
    }


    /**
     * 对所有优惠券进行试算，看那个最省钱
     * @param order 试算请求
     * @return 试算结果
     */
    @Override
    public SimulationResponse simulateOrder(SimulationOrder order) {
        SimulationResponse response = new SimulationResponse();
        long minOrderPrice = Long.MAX_VALUE;

        // 计算每一个优惠券的订单价格
        for (CouponInfo coupon : order.getCouponInfos()) {
            ShoppingCart cart = new ShoppingCart();
            cart.setProducts(order.getProducts());
            cart.setCouponInfos(Lists.newArrayList(coupon));
            cart = couponTemplateFactory.getTemplate(cart).calculate(cart);

            long couponId = coupon.getId();
            long orderPrice = cart.getCost();

            // 设置当前优惠券对应的订单价格
            response.getCouponToOrderPrice().put(couponId, orderPrice);

            // 比较订单价格，设置当前最优优惠券的ID
            if (minOrderPrice > orderPrice) {
                response.setBestCouponId(coupon.getId());
                minOrderPrice = orderPrice;
            }
        }
        return response;
    }
}
