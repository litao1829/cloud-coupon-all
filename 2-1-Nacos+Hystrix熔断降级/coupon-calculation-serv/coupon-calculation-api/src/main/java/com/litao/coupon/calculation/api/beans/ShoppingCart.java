package com.litao.coupon.calculation.api.beans;

import com.litao.coupon.template.api.beans.CouponInfo;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {

    @NotEmpty
    private List<Product> products;

    private Long couponId;

    private long cost;


    /**
     * 目前只支持单张优惠卷，为了以后的扩展考虑，可以添加多个优惠卷的计算逻辑，所以使用List
     */
    private List<CouponInfo> couponInfos;

    @NotNull
    private Long userId;
}
