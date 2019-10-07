package com.ouyang.lesson.vo;

import com.ouyang.lesson.annotation.BigToStr;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ouyangduning
 * @date 2019/10/7 15:41
 */

@Data
public class AccountVo {
    @BigToStr
    private BigDecimal money;
    @BigToStr(length = 3)
    private BigDecimal money1;
    private BigDecimal money2;
}
