package com.litao.coupon.customer.converter;

import com.litao.coupon.customer.dao.entity.Coupon;
import com.litao.coupon.template.api.beans.CouponInfo;

/**
 * @author mqxu
 * @date 2023/9/8
 * @description CouponConverter
 **/
public class CouponConverter {

    public static CouponInfo convertToCoupon(Coupon coupon) {

        return CouponInfo.builder()
                .id(coupon.getId())
                .status(coupon.getStatus().getCode())
                .templateId(coupon.getTemplateId())
                .shopId(coupon.getShopId())
                .userId(coupon.getUserId())
                .template(coupon.getTemplateInfo())
                .build();
    }
}