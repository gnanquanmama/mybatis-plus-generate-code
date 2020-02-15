package com.mcoding.util;


import java.util.List;

public abstract class BeanMapperUtils {


    public static <S, D> D map(S source, Class<D> clazz) {
        if (source == null) {
            return null;
        }

        return null;
    }


    public static <S, D> List<D> mapAsList(List<S> source, Class<D> clazz) {
        return null;
    }


}
