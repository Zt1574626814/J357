package com.bdqn.controller;

import com.bdqn.common.Dto;
import com.bdqn.common.DtoUtil;
import com.bdqn.common.Page;
import com.bdqn.dao.BaseDao;
import com.bdqn.entity.ItripHotelVO;
import com.bdqn.entity.SearchHotCityVO;
import com.bdqn.entity.SearchHotelVO;
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

    @PostMapping("/searchItripHotelListByHotCity")
    public Dto searchItripHotelListByHotCity(@RequestBody SearchHotCityVO vo) throws SolrServerException, IOException {
        BaseDao<ItripHotelVO> dao = new BaseDao<>();
        SolrQuery solrQuery = new SolrQuery("*:*");
        solrQuery.addFilterQuery("cityId:" + vo.getCityId());
        solrQuery.setStart(0);
        solrQuery.setRows(vo.getCount());
        List<ItripHotelVO> list = dao.getList(solrQuery);
        return DtoUtil.returnDataSuccess(list);
    }


    @PostMapping("/searchItripHotelPage")
    public Dto searchItripHotelPage(@RequestBody SearchHotelVO vo) throws SolrServerException, IOException {
        BaseDao<SearchHotelVO> dao = new BaseDao<>();
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("*:*");
        if (vo.getPageNo() == null) vo.setPageNo(1);
        if (vo.getPageSize() == null) vo.setPageSize(5);
        if (vo.getKeywords() != null) solrQuery.addFilterQuery("keyword:" + vo.getKeywords());
        if (vo.getMinPrice() != null) solrQuery.addFilterQuery(" minPrice:[" + vo.getMinPrice() + " TO *]");
        if (vo.getMaxPrice() != null) solrQuery.addFilterQuery(" minPrice:[* TO " + vo.getMaxPrice() + "]");
        if (vo.getDestination() != null) solrQuery.addFilterQuery("destination:" + vo.getDestination());
        if (vo.getHotelLevel() != null) solrQuery.addFilterQuery("hotelLevel:" + vo.getHotelLevel());

        StringBuilder tradingAreaIds = new StringBuilder();
        if (vo.getTradeAreaIds() != null) {
            String[] number = vo.getTradeAreaIds().split(",");
            for (int i = 0; i < number.length; i++) {
                if (i == 0) tradingAreaIds.append("tradingAreaIds:").append(number[i]).append(",*");
                else tradingAreaIds.append(" or tradingAreaIds:").append(number[i]).append(",*");
            }
            solrQuery.addFilterQuery(tradingAreaIds.toString());
        }

        StringBuilder featureIds = new StringBuilder();
        if (vo.getFeatureIds() != null) {
            String[] number = vo.getFeatureIds().split(",");
            for (int i = 0; i < number.length; i++) {
                if (i == 0) featureIds.append("featureIds:").append(number[i]).append(",*");
                else featureIds.append(" or featureIds:").append(number[i]).append(",*");
            }
            solrQuery.addFilterQuery(featureIds.toString());
        }
        // 排序
        if (vo.getAscSort() != null) solrQuery.setSort(vo.getAscSort(), SolrQuery.ORDER.asc);
        if (vo.getDescSort() != null) solrQuery.setSort(vo.getDescSort(), SolrQuery.ORDER.desc);
        Page<ItripHotelVO> page = dao.getListPage(solrQuery, vo.getPageNo(), vo.getPageSize());
        return DtoUtil.returnDataSuccess(page);
    }

}
