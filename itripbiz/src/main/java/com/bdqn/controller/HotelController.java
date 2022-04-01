package com.bdqn.controller;

import com.bdqn.common.Dto;
import com.bdqn.common.DtoUtil;
import com.bdqn.entity.ItripAreaDic;
import com.bdqn.entity.ItripLabelDic;
import com.bdqn.mapper.ItripAreaDicMapper;
import com.bdqn.mapper.ItripLabelDicMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {


    @Resource
    ItripLabelDicMapper itripLabelDicMapper;

    @Resource
    ItripAreaDicMapper itripAreaDicMapper;

    @GetMapping("/querytradearea/{pid}")
    public Dto querytradearea(@PathVariable("pid") String pid){
        return DtoUtil.returnDataSuccess(itripAreaDicMapper.getListByPid(pid));
    }

    @RequestMapping("/queryhotcity/{type}")
    public Dto getCity(@PathVariable("type") int type) {
        List<ItripAreaDic> list = itripAreaDicMapper.queryHotHotel(type);
        if(list.size() == 0){
            return DtoUtil.returnFail("系统异常，获取失败","10202");
        }
        return DtoUtil.returnDataSuccess(list);
    }

    @RequestMapping("/queryhotelfeature")
    public Dto queryHotelFeature() {
        List<ItripLabelDic> list = itripLabelDicMapper.queryHotelFeature();
        if(list.size() == 0){
            return DtoUtil.returnFail("系统异常，获取失败","10205");
        }
        return DtoUtil.returnDataSuccess(list);
    }

}
