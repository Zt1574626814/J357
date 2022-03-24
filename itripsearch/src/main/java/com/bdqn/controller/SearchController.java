package com.bdqn.controller;

import com.bdqn.common.Dto;
import com.bdqn.common.DtoUtil;
import com.bdqn.dao.BaseDao;
import com.bdqn.entity.ItripHotelVO;
import com.bdqn.entity.SearchHotCityVO;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/hotellist")
public class SearchController {

    @PostMapping("searchItripHotelListByHotCity")
    public Dto searchItripHotelListByHotCity(@RequestBody SearchHotCityVO vo) throws SolrServerException, IOException {
        BaseDao<ItripHotelVO> dao = new BaseDao<>();
        SolrQuery solrQuery = new SolrQuery("*:*");
        solrQuery.addFilterQuery("cityId:"+vo.getCityId());
        solrQuery.setStart(0);
        solrQuery.setRows(vo.getCount());
        List<ItripHotelVO> list = dao.getList(solrQuery);
        return DtoUtil.returnDataSuccess(list);
    }

}
