package com.bdqn.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * 区域字典表(ItripAreaDic)实体类
 *
 * @author Zt
 * @since 2022-02-28 15:23:58
 */
public class ItripAreaDic implements Serializable {
    private static final long serialVersionUID = 924622864052729182L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 区域名称
     */
    private String name;
    /**
     * 区域编号
     */
    private String areano;
    /**
     * 父级区域
     */
    private Long parent;
    /**
     * 0:未激活 1:已激活
     */
    private Integer isactivated;
    /**
     * 是否是商圈(0:不是 1:是)
     */
    private Integer istradingarea;
    /**
     * (0:不是 1：是)
     */
    private Integer ishot;
    /**
     * 区域级别(0:国家级 1:省级 2:市级 3:县/区)
     */
    private Integer level;
    /**
     * 1:国内 2：国外
     */
    private Integer ischina;
    
    private String pinyin;
    
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

    public String getAreano() {
        return areano;
    }

    public void setAreano(String areano) {
        this.areano = areano;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public Integer getIsactivated() {
        return isactivated;
    }

    public void setIsactivated(Integer isactivated) {
        this.isactivated = isactivated;
    }

    public Integer getIstradingarea() {
        return istradingarea;
    }

    public void setIstradingarea(Integer istradingarea) {
        this.istradingarea = istradingarea;
    }

    public Integer getIshot() {
        return ishot;
    }

    public void setIshot(Integer ishot) {
        this.ishot = ishot;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getIschina() {
        return ischina;
    }

    public void setIschina(Integer ischina) {
        this.ischina = ischina;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
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

