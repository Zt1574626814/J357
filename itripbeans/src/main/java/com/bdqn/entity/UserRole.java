package com.bdqn.entity;

import java.io.Serializable;

/**
 * (UserRole)实体类
 *
 * @author Zt
 * @since 2022-02-28 15:24:35
 */
public class UserRole implements Serializable {
    private static final long serialVersionUID = 677331936351405468L;
    
    private Integer roleid;
    
    private Integer uid;


    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

}

