package com.attson.knife4jserver.response;

public class Response<T> {
    public Boolean success;

    public T data;

    public String errorMsg;

    public String errorCode;

    public static <T> Response<T> ok(T data) {
        var ok = new Response<T>();

        ok.data = data;

        ok.success = true;

        return ok;
    }

    public static <T> Response<T> fail(String errorCode, String errorMsg) {
        var ok = new Response<T>();

        ok.success = false;
        ok.errorMsg = errorMsg;
        ok.errorCode = errorCode;

        return ok;
    }

    public static <T> Response<T> fail(String errorMsg) {
        var ok = new Response<T>();

        ok.success = false;
        ok.errorMsg = errorMsg;
        ok.errorCode = "500";

        return ok;
    }
}
