package com.bdqn.entity;

import java.io.Serializable;

/**
 * (Role)实体类
 *
 * @author Zt
 * @since 2022-02-28 15:24:35
 */
public class Role implements Serializable {
    private static final long serialVersionUID = 634085492794541148L;
    
    private Integer roleid;
    
    private String name;


    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

