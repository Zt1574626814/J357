package com.bdqn.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * 用户表(ItripUser)实体类
 *
 * @author Zt
 * @since 2022-02-28 15:24:35
 */
public class ItripUser implements Serializable {
    private static final long serialVersionUID = -51832419682452278L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 若是第三方登录，系统将自动生成唯一账号；自注册用户则为邮箱或者手机号
     */
    private String userCode;
    /**
     * 若是第三方登录，系统将自动生成唯一密码；自注册用户则为自定义密码
     */
    private String userPassword;
    /**
     * 用户类型（标识：0 自注册用户 1 微信登录 2 QQ登录 3 微博登录）
     */
    private Integer userType;
    /**
     * 平台ID（根据不同登录用户，进行相应存入：自注册用户主键ID、微信ID、QQID、微博ID）
     */
    private Long flatId;
    /**
     * 用户昵称
     */
    private String userName;
    /**
     * 微信号
     */
    private String weChat;
    /**
     * qq账号
     */
    private String qq;
    /**
     * 微博账号
     */
    private String weibo;
    /**
     * 百度账号
     */
    private String baidu;
    
    private LocalDateTime creationDate;
    
    private Long createdBy;
    
    private LocalDateTime modifyDate;
    
    private Long modifiedBy;
    /**
     * 是否激活,(0 false，1 true,默认是0)
     */
    private Integer activated;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserPassWord() {
        return userPassword;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassword = userPassWord;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Long getFlatId() {
        return flatId;
    }

    public void setFlatId(Long flatId) {
        this.flatId = flatId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWechat() {
        return weChat;
    }

    public void setWechat(String wechat) {
        this.weChat = wechat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }

    public String getBaidu() {
        return baidu;
    }

    public void setBaidu(String baidu) {
        this.baidu = baidu;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Integer getActivated() {
        return activated;
    }

    public void setActivated(Integer activated) {
        this.activated = activated;
    }

    @Override
    public String toString() {
        return "ItripUser{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userType=" + userType +
                ", flatId=" + flatId +
                ", userName='" + userName + '\'' +
                ", wechat='" + weChat + '\'' +
                ", qq='" + qq + '\'' +
                ", weibo='" + weibo + '\'' +
                ", baidu='" + baidu + '\'' +
                ", creationDate=" + creationDate +
                ", createdBy=" + createdBy +
                ", modifyDate=" + modifyDate +
                ", modifiedBy=" + modifiedBy +
                ", activated=" + activated +
                '}';
    }
}

