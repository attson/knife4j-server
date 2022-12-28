package com.attson.knife4jserver.exception;

public class ServiceException extends RuntimeException {
    private final String code;

    public ServiceException(String code, String msg) {
        super(msg);

        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
