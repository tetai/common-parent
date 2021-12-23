package cn.zkz.common.excel.utils;

import java.io.Serializable;

/**
 * @Desc
 * @Author zkz
 * @Date 2021/12/21
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean success = true;

    private T data;

    private Integer errorCode;

    private String errorMessage;


    public boolean isSuccess() {
        return success;
    }


    public Result<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }


    public T getData() {
        return data;
    }


    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }


    public Integer getErrorCode() {
        return errorCode;
    }


    public Result<T> setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
        return this;
    }


    public String getErrorMessage() {
        return errorMessage;
    }


    public Result<T> setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public Result<T> setFailed(Integer errorCode, String errorMessage) {
        this.success = false;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        return this;
    }


    public static <T> Result<T> success(T value) {
        Result<T> r = new Result<T>();
        r.setData(value);
        return r;
    }


}
