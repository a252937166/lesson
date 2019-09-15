package com.ouyang.lesson.response;

import lombok.Data;

/**
 * @author ouyangduning
 * @date 2019/9/15 16:33
 */
@Data
public class MyResponse<T> {
    public MyResponse(ResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.msg = responseEnum.getMsg();
    }
    private String code;
    private String msg;
    private T data;
}
