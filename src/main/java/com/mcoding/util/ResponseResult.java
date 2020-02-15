package com.mcoding.util;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wzt
 */
@Builder
@Data
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String msg;

    private T data;

    public static ResponseResult<String> success() {
        return success(null);
    }

    public static <T> ResponseResult<T> success(T data) {
        return ResponseResult.<T>builder()
                .code(ResponseCode.Success.getCode())
                .msg(ResponseCode.Success.getMsg())
                .data(data)
                .build();
    }

    public static ResponseResult<String> fail(String msg) {
        return fail(ResponseCode.Fail, msg);
    }

    public static <T> ResponseResult<T> fail(ResponseCode responseCode, String msg) {
        return ResponseResult.<T>builder()
                .code(responseCode.getCode())
                .msg(msg)
                .build();
    }

}
