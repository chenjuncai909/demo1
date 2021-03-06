package com.cjc.demo1.enums;

public enum ErrorCodeAndMsg {

    User_id_does_not_exist("0001","用户Id不存在"),
    User_id_is_empty("0002","用户Id为空"),
    User_name_is_empty ("0003","用户名为空"),
    User_is_empty("0004","用户为空"),
    User_does_not_exist("0005","用户不存在"),
    Network_error("9999","网络错误，待会重试"),
    ;

    private String code;
    private String msg;

    ErrorCodeAndMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

}
