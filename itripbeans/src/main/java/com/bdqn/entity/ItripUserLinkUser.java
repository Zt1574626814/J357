package com.bdqn.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (ItripUserLinkUser)实体类
 *
 * @author Zt
 * @since 2022-02-28 15:24:35
 */
public class ItripUserLinkUser implements Serializable {
    private static final long serialVersionUID = 273860306806178187L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 常用联系人姓名
     */
    private String linkUserName;
    /**
     * 证件号码
     */
    private String linkIdCard;
    /**
     * 常用联系人电话
     */
    private String linkPhone;
    /**
     * 用户id
     */
    private Long userId;
    
    private Date creationDate;
    
    private Long createdBy;
    
    private Date modifyDate;
    
    private Long modifiedBy;
    /**
     * 证件类型：(0-身份证，1-护照，2-学生证，3-军人证，4-驾驶证，5-旅行证)
     */
    private Integer linkIdCardType;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkUserName() {
        return linkUserName;
    }

    public void setLinkUserName(String linkUserName) {
        this.linkUserName = linkUserName;
    }

    public String getLinkIdCard() {
        return linkIdCard;
    }

    public void setLinkIdCard(String linkIdCard) {
        this.linkIdCard = linkIdCard;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Integer getLinkIdCardType() {
        return linkIdCardType;
    }

    public void setLinkIdCardType(Integer linkIdCardType) {
        this.linkIdCardType = linkIdCardType;
    }
}

