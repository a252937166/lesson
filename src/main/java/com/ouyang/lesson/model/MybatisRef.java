package com.ouyang.lesson.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * mybatis_ref
 * @author 
 */
@Data
public class MybatisRef implements Serializable {
    private Integer id;

    private String stringCol;

    private Boolean booleanCol;

    private Date dateCol;

    private Date timeCol;

    private Integer intCol;

    private Long longCol;

}