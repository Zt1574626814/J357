package com.bdqn.controller;

import com.bdqn.common.DateUtil;
import com.bdqn.common.Dto;
import com.bdqn.common.DtoUtil;
import com.bdqn.entity.SearchHotelRoomVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HotelRoomController {

    @PostMapping("/queryhotelroombyhotel")
    public Dto queryhotelroombyhotel(@RequestBody SearchHotelRoomVO vo){
        Long hotelId = vo.getHotelId();
        // 获取入住时间和退房时间内所有的日期
        List<Date> dates = DateUtil.getBetweenDates(vo.getStartDate(), vo.getEndDate());
        return DtoUtil.returnSuccess();
    }

}
