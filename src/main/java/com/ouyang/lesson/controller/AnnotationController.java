package com.ouyang.lesson.controller;

import com.ouyang.lesson.response.MyResponse;
import com.ouyang.lesson.response.ResponseEnum;
import com.ouyang.lesson.vo.AccountVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author ouyangduning
 * @date 2019/9/15 16:12
 */
@RestController
@RequestMapping("/annotation")
public class AnnotationController {

    @GetMapping("/test")
    public MyResponse<AccountVo> logTest() {
        MyResponse<AccountVo> myResponse = new MyResponse<>(ResponseEnum.SUCCESS);
        AccountVo vo = new AccountVo();
        vo.setMoney(new BigDecimal(1.245454));
        vo.setMoney1(new BigDecimal(1.245454));
        vo.setMoney2(new BigDecimal(1.245454));
        myResponse.setData(vo);
        return myResponse;
    }

}
