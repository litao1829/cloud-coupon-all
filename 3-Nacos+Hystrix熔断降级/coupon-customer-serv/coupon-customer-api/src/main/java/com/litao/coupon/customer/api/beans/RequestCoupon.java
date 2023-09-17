package com.litao.coupon.customer.api.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestCoupon {


    /**
     * 用户id
     */
    @NotNull
    private Long userId;

    /**
     * 优惠券模板id
     */
    @NotNull
    private Long couponTemplatedId;

}
