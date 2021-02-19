package com.atguigu.springcloud.contant;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum ResponseCode {

    SUCCESS(10000, "SUCCESS"),
    ERROR(10001, "ERROR"),
    NEED_LOGIN(10002, "NEED_LOGIN"),
    ILLEGAL_ARGUMENT(10003, "ILLEGAL_ARGUMENT");


    private Integer code;
    private String desc;


    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }


}
