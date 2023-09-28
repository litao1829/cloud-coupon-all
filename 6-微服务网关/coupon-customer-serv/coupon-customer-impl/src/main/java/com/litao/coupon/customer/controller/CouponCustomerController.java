package com.litao.coupon.customer.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import com.litao.coupon.calculation.api.beans.ShoppingCart;
import com.litao.coupon.calculation.api.beans.SimulationOrder;
import com.litao.coupon.calculation.api.beans.SimulationResponse;
import com.litao.coupon.customer.api.beans.RequestCoupon;
import com.litao.coupon.customer.api.beans.SearchCoupon;
import com.litao.coupon.customer.dao.entity.Coupon;
import com.litao.coupon.customer.service.CouponCustomerService;
import com.litao.coupon.template.api.beans.CouponInfo;

import java.util.List;

/**
 * @author mqxu
 * @date 2023/9/8
 * @description CouponCustomerController
 **/
@Slf4j
@RestController
@RequestMapping("coupon-customer")
@RefreshScope
public class CouponCustomerController {

    @Resource
    private CouponCustomerService customerService;

    @Value("${flag:false}")
    private Boolean flag;

    /**
     * 用户领券接口
     *
     * @param request 请求对象
     * @return 优惠券模板信息
     */
    @PostMapping("requestCoupon")
    public Coupon requestCoupon(@Valid @RequestBody RequestCoupon request) {
        log.info(request.toString());
        if (!flag) {
            log.info("暂停领取优惠券");
            return null;
        }
        return customerService.requestCoupon(request);
    }

    /**
     * 用户删除优惠券
     *
     * @param userId   用户id
     * @param couponId 优惠券id
     */
    @DeleteMapping("deleteCoupon")
    public void deleteCoupon(@RequestParam("userId") Long userId,
                             @RequestParam("couponId") Long couponId) {
        customerService.deleteCoupon(userId, couponId);
    }

    /**
     * 用户模拟计算每个优惠券的优惠价格
     *
     * @param order 订单信息
     * @return 优惠券模板信息
     */
    @PostMapping("simulateOrder")
    public SimulationResponse simulate(@Valid @RequestBody SimulationOrder order) {
        return customerService.simulateOrderPrice(order);
    }

    /**
     * 下单核销优惠券
     *
     * @param info 订单信息
     * @return 优惠券模板信息
     */
    @PostMapping("placeOrder")
    public ShoppingCart checkout(@Valid @RequestBody ShoppingCart info) {
        return customerService.placeOrder(info);
    }


    /**
     * 查询用户优惠券
     *
     * @param request 查询条件
     * @return 优惠券模板信息
     */
    @PostMapping("findCoupon")
    public List<CouponInfo> findCoupon(@Valid @RequestBody SearchCoupon request) {
        return customerService.findCoupon(request);
    }

}
