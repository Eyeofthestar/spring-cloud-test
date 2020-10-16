package com.api.cloud.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * payment
 * @author 
 */
@Data
public class Payment implements Serializable {
    private Integer id;

    private String searial;

    private static final long serialVersionUID = 1L;
}