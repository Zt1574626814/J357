package com.bdqn.entity;

import java.io.Serializable;

/**
 * (FunctRole)实体类
 *
 * @author Zt
 * @since 2022-02-28 15:23:58
 */
public class FunctRole implements Serializable {
    private static final long serialVersionUID = 245004277318392240L;
    
    private Integer roleid;
    
    private Integer functid;


    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getFunctid() {
        return functid;
    }

    public void setFunctid(Integer functid) {
        this.functid = functid;
    }

}

