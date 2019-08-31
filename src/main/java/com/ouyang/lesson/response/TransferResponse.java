package com.ouyang.lesson.response;

import lombok.Data;

/**
 * @author ouyangduning
 * @date 2019/9/1 02:31
 */
@Data
public class TransferResponse {
    private boolean success = true;
    /**
     * 账户A余额
     */
    private Integer balanceA;
    /**
     * 账户B余额
     */
    private Integer balanceB;
}
