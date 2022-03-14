package com.bdqn.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * 原始库存表(ItripProductStore)实体类
 *
 * @author Zt
 * @since 2022-02-28 15:24:34
 */
public class ItripProductStore implements Serializable {
    private static final long serialVersionUID = -49439206015235414L;
    
    private Long id;
    /**
     * 商品类型(0:旅游产品 1:酒店产品 2:机票产品)
     */
    private Integer producttype;
    /**
     * 商品id
     */
    private Long productid;
    /**
     * 商品库存
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

    public Integer getProducttype() {
        return producttype;
    }

    public void setProducttype(Integer producttype) {
        this.producttype = producttype;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
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

