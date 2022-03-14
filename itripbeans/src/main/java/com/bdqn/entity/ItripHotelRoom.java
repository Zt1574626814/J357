package com.bdqn.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * 酒店房间表(ItripHotelRoom)实体类
 *
 * @author Zt
 * @since 2022-02-28 15:24:31
 */
public class ItripHotelRoom implements Serializable {
    private static final long serialVersionUID = -42733405518629786L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 酒店ID
     */
    private Long hotelid;
    /**
     * 房间名称
     */
    private String roomtitle;
    /**
     * 房间价格
     */
    private Double roomprice;
    /**
     * 酒店床型
     */
    private Long roombedtypeid;
    /**
     * 是否包含早餐
     */
    private Integer ishavingbreakfast;
    /**
     * 1:在线付 2:到店付 3:不限
     */
    private Integer paytype;
    /**
     * 满意度（冗余字段，在用户评论后更新）
     */
    private Object satisfaction;
    /**
     * 是否可预订(0:不可以 1:可以)
     */
    private Integer isbook;
    /**
     * 是否可取消(0:不可 1:可以)
     */
    private Integer iscancel;
    /**
     * 是否及时响应(0:不及时 1:及时)
     */
    private Integer istimelyresponse;
    
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

    public String getRoomtitle() {
        return roomtitle;
    }

    public void setRoomtitle(String roomtitle) {
        this.roomtitle = roomtitle;
    }

    public Double getRoomprice() {
        return roomprice;
    }

    public void setRoomprice(Double roomprice) {
        this.roomprice = roomprice;
    }

    public Long getRoombedtypeid() {
        return roombedtypeid;
    }

    public void setRoombedtypeid(Long roombedtypeid) {
        this.roombedtypeid = roombedtypeid;
    }

    public Integer getIshavingbreakfast() {
        return ishavingbreakfast;
    }

    public void setIshavingbreakfast(Integer ishavingbreakfast) {
        this.ishavingbreakfast = ishavingbreakfast;
    }

    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }

    public Object getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(Object satisfaction) {
        this.satisfaction = satisfaction;
    }

    public Integer getIsbook() {
        return isbook;
    }

    public void setIsbook(Integer isbook) {
        this.isbook = isbook;
    }

    public Integer getIscancel() {
        return iscancel;
    }

    public void setIscancel(Integer iscancel) {
        this.iscancel = iscancel;
    }

    public Integer getIstimelyresponse() {
        return istimelyresponse;
    }

    public void setIstimelyresponse(Integer istimelyresponse) {
        this.istimelyresponse = istimelyresponse;
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

