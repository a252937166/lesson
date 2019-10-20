package com.ouyang.lesson.controller;

import com.ouyang.lesson.response.MyResponse;
import com.ouyang.lesson.response.ResponseEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ouyangduning
 * @date 2019/10/20 20:13
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @GetMapping("test")
    public MyResponse test() {
        return new MyResponse(ResponseEnum.SUCCESS);
    }
}
