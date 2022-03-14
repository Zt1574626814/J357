package com.bdqn.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * 图片表(ItripImage)实体类
 *
 * @author Zt
 * @since 2022-02-28 15:24:33
 */
public class ItripImage implements Serializable {
    private static final long serialVersionUID = 341165458747972974L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 图片类型(0:酒店图片1:房间图片2:评论图片)
     */
    private String type;
    /**
     * 关联id
     */
    private Long targetid;
    /**
     * 图片s上传顺序位置
     */
    private Integer position;
    /**
     * 图片地址
     */
    private String imgurl;
    
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTargetid() {
        return targetid;
    }

    public void setTargetid(Long targetid) {
        this.targetid = targetid;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
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

