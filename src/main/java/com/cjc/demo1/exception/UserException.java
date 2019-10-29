package com.cjc.demo1.exception;

import com.cjc.demo1.enums.ErrorCodeAndMsg;

public class UserException extends RuntimeException {
    private static final long serialVersionUID = -6370612186038915645L;

    private final ErrorCodeAndMsg response;



    public UserException(ErrorCodeAndMsg response) {
        this.response = response;
    }

    public ErrorCodeAndMsg getResponse() {
        return response;
    }


}
