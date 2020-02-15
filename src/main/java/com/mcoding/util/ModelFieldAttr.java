package com.mcoding.util;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author wzt on 2020/2/12.
 * @version 1.0
 */
@Data
@AllArgsConstructor
public class ModelFieldAttr {

    private String tableFieldName;
    private String modelFieldType;
}
