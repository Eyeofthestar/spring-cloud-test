package com.cloud.pojo;

import java.io.Serializable;
import lombok.Data;

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