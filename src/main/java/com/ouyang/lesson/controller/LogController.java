package com.ouyang.lesson.controller;

import com.ouyang.lesson.response.MyResponse;
import com.ouyang.lesson.response.ResponseEnum;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ouyangduning
 * @date 2019/9/15 16:12
 */
@RestController
@RequestMapping("/log")
public class LogController {

    @GetMapping("/test")
    public MyResponse logTest(@Param("param") String param) {
        return new MyResponse(ResponseEnum.SUCCESS);
    }

    @GetMapping("/error")
    public MyResponse errorTest(@Param("param") String param) {
        int a = 1/0;
        return new MyResponse(ResponseEnum.SUCCESS);
    }
}
