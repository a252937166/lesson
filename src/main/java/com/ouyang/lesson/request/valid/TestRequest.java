package com.ouyang.lesson.request.valid;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * @author ouyangduning
 * @date 2019/9/15 17:30
 */
@Data
public class TestRequest {
    @NotEmpty
    private String name;
    @Length(max = 3)
    private String msg;
}
