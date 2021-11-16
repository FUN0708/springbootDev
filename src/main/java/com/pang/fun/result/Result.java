package com.pang.fun.result;

/**
 * 返回HTML响应的结果
 */
public class Result {
    //响应码
    private int code;

    private String message;
    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
