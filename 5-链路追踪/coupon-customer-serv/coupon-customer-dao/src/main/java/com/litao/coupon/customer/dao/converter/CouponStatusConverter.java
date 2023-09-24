package com.litao.coupon.customer.dao.converter;

import com.litao.coupon.customer.api.enums.CouponStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;


@Convert
public class CouponStatusConverter implements AttributeConverter<CouponStatus,Integer> {

    @Override
    public Integer convertToDatabaseColumn(CouponStatus couponStatus) {
        return couponStatus.getStatus();
    }

    @Override
    public CouponStatus convertToEntityAttribute(Integer status) {
        return CouponStatus.convert(status);
    }
}



