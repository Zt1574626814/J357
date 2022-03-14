package com.bdqn.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * (ItripHotelExtendProperty)实体类
 *
 * @author Zt
 * @since 2022-02-28 15:24:04
 */
public class ItripHotelExtendProperty implements Serializable {
    private static final long serialVersionUID = 777484807154871996L;

    private Long id;
    /**
     * 酒店id
     */
    private Long hotelid;
    /**
     * 推广属性
     */
    private Long extendpropertyid;

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

    public Long getHotelid() {
        return hotelid;
    }

    public void setHotelid(Long hotelid) {
        this.hotelid = hotelid;
    }

    public Long getExtendpropertyid() {
        return extendpropertyid;
    }

    public void setExtendpropertyid(Long extendpropertyid) {
        this.extendpropertyid = extendpropertyid;
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

