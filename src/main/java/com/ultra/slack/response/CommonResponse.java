package com.ultra.slack.response;

/**
 * Created by YG on 2016-06-22.
 */
public class CommonResponse {

    CommonResponse(boolean result, String message) {
        this.result = result;
        this.message = message;
    }

    private boolean result;

    private String message;


    public boolean isResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public static CommonResponse SUCCESS = new CommonResponse(true, "성공");

    public static CommonResponse FAILED(String message) {
        return new CommonResponse(false, message);
    }
}
