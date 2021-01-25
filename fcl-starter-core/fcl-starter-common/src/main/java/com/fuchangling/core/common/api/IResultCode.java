package com.fuchangling.core.common.api;

/**
 * 返回码接口
 *
 * @author harlin
 */
public interface IResultCode {

    /**
     * 返回码
     *
     * @return int
     */
    int getCode();

    /**
     * 返回信息
     *
     * @return string
     */
    String getMsg();
}
