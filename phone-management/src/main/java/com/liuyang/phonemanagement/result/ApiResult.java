package com.liuyang.phonemanagement.result;

import lombok.Data;

@Data
public class ApiResult<T> {
    /**
     * 错误码.
     */
    private Integer code;

    /**
     * 提示信息.
     */
    private String msg;

    /**
     * 具体内容.
     */
    private T data;

    public ApiResult() {
    }

    public ApiResult(Integer code, String msg, T t) {
        this.code = code;
        this.msg = msg;
        this.data = t;
    }

    public ApiResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ApiResult sendResult(Integer code, String msg, Object t) {
        return new ApiResult(code, msg, t);
    }

    public static ApiResult sendResult(Integer code, String msg) {
        return new ApiResult(code, msg);
    }

    public int getCode() {
        return this.code;
    }

    public T getData(){
        return this.data;
    }
}
