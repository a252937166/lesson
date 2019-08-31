package com.ouyang.lesson.controller;

import com.ouyang.lesson.request.wallet.TransferRequest;
import com.ouyang.lesson.response.TransferResponse;
import com.ouyang.lesson.service.WallectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ouyangduning
 * @date 2019/9/1 01:57
 */
@RestController
@Slf4j
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WallectService wallectService;
    /**
     * 转账业务
     * 因为这里的重点是测试事务，为了方便，直接采用get方式请求
     * @param request 请求参数
     * @return
     */
    @GetMapping("/transfer")
    public TransferResponse transfer(TransferRequest request) {
        TransferResponse response = new TransferResponse();
        try {
            response.setSuccess(wallectService.transfer(request.getFrom(), request.getTo(), request.getMoney()));
        } catch (Exception e) {
            response.setSuccess(false);
        }
        response.setBalanceA(wallectService.findById(request.getFrom()).getBalance());
        response.setBalanceB(wallectService.findById(request.getTo()).getBalance());
        return response;
    }
}
