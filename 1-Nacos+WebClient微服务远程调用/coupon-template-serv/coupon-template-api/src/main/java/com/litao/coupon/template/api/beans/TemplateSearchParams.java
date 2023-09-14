package com.litao.coupon.template.api.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 封装优惠卷分页查询参数,
 * （这里不知道是不是查询用户自己的优惠卷，没有当前用户的id的属性所以估计
 * 不需要从前端传递当前按用户id，可能在后端获取当前用户id）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TemplateSearchParams {

    private Long id;

    private String name;

    private String type;

    private Long shopId;

    private Boolean available;

    private int page;

    private int pageSize;
}
