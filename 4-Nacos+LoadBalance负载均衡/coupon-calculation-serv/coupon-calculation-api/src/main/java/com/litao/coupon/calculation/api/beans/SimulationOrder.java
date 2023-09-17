package com.litao.coupon.calculation.api.beans;

import com.litao.coupon.template.api.beans.CouponInfo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 试运算订单最优的优惠券
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimulationOrder {


    @NotEmpty
    private List<Product> products;

    @NotEmpty
    private List<Long> couponIDs;

    private List<CouponInfo> couponInfos;

    @NotNull
    private Long userId;
}
