package com.litao.coupon.customer.api.enums;

import com.litao.coupon.template.api.enums.CouponType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum CouponStatus {
    USED("已使用",2),
    AVAILABLE("未使用",1),
    INACTIVE("已注销",3);


    private final String desc;
    private final Integer status;

    public static CouponStatus convert(Integer status){
        if(status==null){
            return null;
        }
        return Stream.of(values())
                .filter(bean->bean.status.equals(status))
                .findFirst()
                .orElse(null);
    }


}
