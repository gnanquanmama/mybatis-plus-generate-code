package com.mcoding.util;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Getter;

import java.util.Map;
import java.util.Objects;

/**
 * @author wzt on 2020/2/11.
 * @version 1.0
 */
@Getter
public class SmartWrapper<T> {

    private boolean isContainOrderByCommand = false;

    private int current = 1;

    private int size = 10;

    private QueryWrapper<T> queryWrapper = new QueryWrapper<>();

    private Map<String, ModelFieldAttr> modelFieldToTableField = null;

    public static <T> SmartWrapper<T> newWrapper() {
        return new SmartWrapper<>();
    }

    public IPage<T> generatePage() {
        return new Page<>(this.current, this.size);
    }

    /**
     * 解析JSON查询字符串, 构建QueryWrapper对象
     *
     * @param queryObject
     * @param clazz
     * @return
     */
    public void parse(JSONObject queryObject, Class<T> clazz) {
        if (Objects.isNull(queryObject)) {
            return;
        }

        // 获取模型字段元信息
        modelFieldToTableField = ModelAttrUtils.generateModelAttr(clazz);

        // 解析查询条件
        this.parseQueryCondition(queryObject, clazz);

        // 解析排序条件
        this.parseOrderByCondition(queryObject);

        // 解析分页信息
        this.parsePage(queryObject);
    }


    private void parsePage(JSONObject queryObject) {
        if (Objects.isNull(queryObject)) {
            return;
        }

        Object current = queryObject.get("current");
        Object size = queryObject.get("size");
        if (current == null || size == null) {
            return;
        }

        this.current = (int) current;
        this.size = (int) size;
    }

    /**
     * 解析排序条件
     *
     * @param queryObject
     * @return
     */
    private void parseOrderByCondition(JSONObject queryObject) {


    }

    /**
     * 根据自定义语法解析查询条件
     *
     * @param queryObject
     * @param clazz
     * @return
     */
    private void parseQueryCondition(JSONObject queryObject, Class<T> clazz) {

    }

}
