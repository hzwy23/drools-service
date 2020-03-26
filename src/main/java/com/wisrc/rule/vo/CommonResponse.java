package com.wisrc.rule.vo;

import lombok.Data;

@Data
public class CommonResponse<T> {

    private String code;

    private String msg;

    private T data;

}
