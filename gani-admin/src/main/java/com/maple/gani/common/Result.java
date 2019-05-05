package com.maple.gani.common;

import java.io.Serializable;

public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int STATUS_OK = 2000;
    public static final int STATUS_ILLEGAL_REQUEST = 4000;
    public static final int STATUS_ILLEGAL_STATE = 4001;
    public static final int STATUS_UNKNOWN = 5000;

    private int status = STATUS_OK;

    private String message;

    private T data;

    public Result() {
        this(STATUS_OK, null, null);
    }

    public Result(T result) {
        this(STATUS_OK, null, result);
    }

    public Result(int status, String message) {
        this(status, message, null);
    }

    public Result(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public Result<T> setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T value) {
        this.data = value;
        return this;
    }

    public boolean success() {
        return STATUS_OK == status;
    }

    public Result<T> reset() {
        setStatus(STATUS_OK).setMessage(null).setData(null);
        return this;
    }
}
