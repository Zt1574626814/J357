package com.bdqn.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * 标签字典表(ItripLabelDic)实体类
 *
 * @author Zt
 * @since 2022-02-28 15:24:33
 */
public class ItripLabelDic implements Serializable {
    private static final long serialVersionUID = 619675689769605300L;
    /**
     * 主键
     */
    private Long id;
    /**
     * key值
     */
    private String name;
    /**
     * value值
     */
    private String value;
    /**
     * 描述
     */
    private String description;
    /**
     * 父级标签id(1级标签则为0)
     */
    private Long parentid;
    /**
     * 标签图片地址
     */
    private String pic;
    
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
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

