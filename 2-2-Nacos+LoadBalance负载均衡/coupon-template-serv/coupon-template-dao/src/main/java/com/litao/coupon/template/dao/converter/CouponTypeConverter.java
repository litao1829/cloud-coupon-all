package com.litao.coupon.template.dao.converter;


import com.litao.coupon.template.api.enums.CouponType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;

/**
 * 这里进行将枚举对象转换为值
 * 将值转换为枚举类中的枚举对象
 */

@Convert
public class CouponTypeConverter implements AttributeConverter<CouponType,String> {

    @Override
    public String convertToDatabaseColumn(CouponType couponType) {
        return couponType.getCode();
    }

    @Override
    public CouponType convertToEntityAttribute(String code) {
        return CouponType.convert(code);
    }
}
