package com.ouyang.lesson.response;

import lombok.AllArgsConstructor;

/**
 * @author ouyangduning
 * @date 2019/9/15 16:35
 */
@AllArgsConstructor
public enum ResponseEnum {
    /**
     * 成功
     */
    SUCCESS("000","成功"),
    /**
     * 失败
     */
    FAIL("999","失败");

    private String code;
    private String msg;

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
