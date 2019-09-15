package com.ouyang.lesson.controller;

import com.ouyang.lesson.request.valid.TestRequest;
import com.ouyang.lesson.response.MyResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * @author ouyangduning
 * @date 2019/9/15 17:27
 */
@RestController
@RequestMapping("/valid")
public class ValidController {

    @GetMapping("/get")
    public MyResponse get(@Valid TestRequest request) {
        return MyResponse.success();
    }

    @PostMapping("/post")
    public MyResponse post(@RequestBody @Valid TestRequest request) {
        return MyResponse.success();
    }
}
