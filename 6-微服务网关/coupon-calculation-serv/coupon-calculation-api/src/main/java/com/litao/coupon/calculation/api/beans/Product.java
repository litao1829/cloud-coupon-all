package com.litao.coupon.calculation.api.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mqxu
 * @date 2023/9/8
 * @description Product
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 商品价格
     */
    private Long price;

    /**
     * 商品在购物车里的数量
     */
    private Integer count;

    /**
     * 商品销售的门店id
     */
    private Long shopId;

}
