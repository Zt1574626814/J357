package com.bdqn.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * 实时库存表(ItripHotelTempStore)实体类
 *
 * @author Zt
 * @since 2022-02-28 15:24:32
 */
public class ItripHotelTempStore implements Serializable {
    private static final long serialVersionUID = -86808176056467231L;
    
    private Long id;
    
    private Integer hotelid;
    /**
     * 商品id
     */
    private Long roomid;
    /**
     * 记录时间
     */
    private LocalDateTime recorddate;
    /**
     * 库存
     */
    private Integer store;
    
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

    public Integer getHotelid() {
        return hotelid;
    }

    public void setHotelid(Integer hotelid) {
        this.hotelid = hotelid;
    }

    public Long getRoomid() {
        return roomid;
    }

    public void setRoomid(Long roomid) {
        this.roomid = roomid;
    }

    public LocalDateTime getRecorddate() {
        return recorddate;
    }

    public void setRecorddate(LocalDateTime recorddate) {
        this.recorddate = recorddate;
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
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

