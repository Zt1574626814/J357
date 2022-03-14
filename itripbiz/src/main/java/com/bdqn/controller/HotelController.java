package com.bdqn.controller;

import com.bdqn.common.Dto;
import com.bdqn.common.DtoUtil;
import com.bdqn.entity.ItripAreaDic;
import com.bdqn.entity.ItripLabelDic;
import com.bdqn.mapper.ItripAreaDicMapper;
import com.bdqn.mapper.ItripLabelDicMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/api/hotel")
public class HotelController {

    @Resource
    ItripAreaDicMapper mapper1;

    @Resource
    ItripLabelDicMapper mapper2;

    @RequestMapping("/queryhotcity/{type}")
    @ResponseBody
    public Dto getCity(@PathVariable("type") int type) {
        List<ItripAreaDic> list = mapper1.queryHotHotel(type);
        if(list.size() == 0){
            return DtoUtil.returnFail("系统异常，获取失败","10202");
        }
        return DtoUtil.returnDataSuccess(list);
    }

    @RequestMapping("/queryhotelfeature")
    @ResponseBody
    public Dto queryHotelFeature() {
        List<ItripLabelDic> list = mapper2.queryHotelFeature();
        if(list.size() == 0){
            return DtoUtil.returnFail("系统异常，获取失败","10205");
        }
        return DtoUtil.returnDataSuccess(list);
    }

}
