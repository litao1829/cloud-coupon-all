package com.litao.coupon.customer.api.beans;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
