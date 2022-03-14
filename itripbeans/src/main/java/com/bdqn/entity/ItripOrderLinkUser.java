package com.bdqn.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * (ItripOrderLinkUser)实体类
 *
 * @author Zt
 * @since 2022-02-28 15:24:34
 */
public class ItripOrderLinkUser implements Serializable {
    private static final long serialVersionUID = -48568500401314448L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 订单id
     */
    private Long orderid;
    /**
     * 联系人id
     */
    private Long linkuserid;
    /**
     * 入住人姓名逗号分隔
     */
    private String linkusername;
    
    private LocalDateTime creationdate;
    
    private Long createdby;
    
    private LocalDateTime modifydate;
    
    private Long modifiedby;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Long getLinkuserid() {
        return linkuserid;
    }

    public void setLinkuserid(Long linkuserid) {
        this.linkuserid = linkuserid;
    }

    public String getLinkusername() {
        return linkusername;
    }

    public void setLinkusername(String linkusername) {
        this.linkusername = linkusername;
    }

    public LocalDateTime getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(LocalDateTime creationdate) {
        this.creationdate = creationdate;
    }

    public Long getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }

    public LocalDateTime getModifydate() {
        return modifydate;
    }

    public void setModifydate(LocalDateTime modifydate) {
        this.modifydate = modifydate;
    }

    public Long getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(Long modifiedby) {
        this.modifiedby = modifiedby;
    }

}

