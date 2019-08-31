package com.ouyang.lesson.request.wallet;

import lombok.Data;

/**
 * @author ouyangduning
 * @date 2019/9/1 02:02
 */
@Data
public class TransferRequest {
    private Integer from;
    private Integer to;
    private Integer money;
}
