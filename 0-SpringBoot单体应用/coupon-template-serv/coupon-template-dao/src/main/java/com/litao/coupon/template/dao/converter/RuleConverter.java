package com.litao.coupon.template.dao.converter;

import com.alibaba.fastjson.JSON;
import com.litao.coupon.template.api.beans.rules.TemplateRule;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;

/**
 *RuleConverter
 * （这里转换是为了将规则对象转换为json，存到数据库）
 */


@Convert
public class RuleConverter implements AttributeConverter<TemplateRule,String> {
    @Override
    public String convertToDatabaseColumn(TemplateRule templateRule) {
        return JSON.toJSONString(templateRule);
    }

    @Override
    public TemplateRule convertToEntityAttribute(String rule) {
        return JSON.parseObject(rule, TemplateRule.class);
    }

}
