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

    public static MyResponse fail (String msg) {
        MyResponse myResponse = new MyResponse(ResponseEnum.FAIL);
        myResponse.setMsg(msg);
        return myResponse;
    }

    public static MyResponse success (String msg) {
        MyResponse myResponse = new MyResponse(ResponseEnum.SUCCESS);
        myResponse.setMsg(msg);
        return myResponse;
    }

    public static MyResponse fail () {
        MyResponse myResponse = new MyResponse(ResponseEnum.FAIL);
        return myResponse;
    }

    public static MyResponse success () {
        MyResponse myResponse = new MyResponse(ResponseEnum.SUCCESS);
        return myResponse;
    }
}
