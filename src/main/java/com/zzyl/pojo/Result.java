package com.zzyl.pojo;

import lombok.Data;

/**
 * 返回结果
 */
@Data
public class Result<T> {
    private int code;//响应返回编码 200--成功, 500--失败
    private String msg;//提示消息
    private T data;//业务数据

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /*** 初始化一个新创建的 AjaxResult 对象*/
    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        if (data != null) {
            this.data = data;
        }
    }
    /**返回成功消息*/
    public static Result success() {
        return new Result<>(200, "操作成功!", null);
    }
    /*返回成功数据*/
    public static Result success(Object data) {
        return new Result<>(200, "操作成功!", data);
    }
    /**返回错误消息*/
    public static Result<Object> error(String msg) {
        return  new Result<>(500, msg, null);
    }


}
