package com.mcoding.util;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * @author wzt on 2020/2/11.
 * @version 1.0
 */
public class SmartWrappers {


    /**
     * 根据自定义语法创建 QueryWrapper
     *
     * @param queryObject
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> QueryWrapper<T> create(JSONObject queryObject, Class<T> clazz) {
        return new QueryWrapper<>();
    }

    public static <T> QueryWrapper<T> newWrapper() {
        return new QueryWrapper<>();
    }

}
