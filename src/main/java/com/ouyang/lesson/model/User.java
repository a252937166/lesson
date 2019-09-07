package com.ouyang.lesson.model;

import lombok.Data;

import java.util.Date;

/**
 * user
 * @author 
 */
@Data
public class User {
    private Integer id;

    private String name;

    private Integer age;

    private String phone;

    private Date createDate;

    private Date updateDate;

}