package com.bdqn.entity;

import java.io.Serializable;

/**
 * (Funct)实体类
 *
 * @author Zt
 * @since 2022-02-28 15:23:58
 */
public class Funct implements Serializable {
    private static final long serialVersionUID = 881020535237959564L;
    
    private Integer functid;
    
    private String name;


    public Integer getFunctid() {
        return functid;
    }

    public void setFunctid(Integer functid) {
        this.functid = functid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

