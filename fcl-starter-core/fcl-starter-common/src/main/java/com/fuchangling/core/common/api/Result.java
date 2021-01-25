package com.fuchangling.core.common.api;

import java.io.Serializable;

/**
 * 统一相应报文
 *
 * @param <T> VO对象
 */
@SuppressWarnings("unused")
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    private Boolean success = true;

    /**
     * 返回处理消息
     */
    private String message = "success";

    /**
     * 返回代码
     */
    private Integer code = 200;

    /**
     * 返回数据对象 data
     */
    private T data;

    /**
     * 时间戳
     */
    private Long timestamp = System.currentTimeMillis();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
