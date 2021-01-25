package com.fuchangling.core.common.api;

public enum ResultCode implements IResultCode {

    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功"),

    /**
     * 业务异常
     */
    FAILURE(400, "业务异常"),

    /**
     * 服务未找到
     */
    NOT_FOUND(404, "服务未找到"),

    /**
     * 服务异常
     */
    ERROR(500, "服务异常");


    final int code;

    final String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
