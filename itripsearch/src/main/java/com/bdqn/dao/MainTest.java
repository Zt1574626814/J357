package com.bdqn.dao;

import com.bdqn.entity.ItripHotelVO;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;

import java.io.IOException;
import java.util.List;

public class MainTest {

    public static void main(String[] args) throws SolrServerException, IOException {
        String url = "http://localhost:8080/solr/hotelCore/";
        // 通过solr客户端加载远程地址
        HttpSolrClient client = new HttpSolrClient(url);
        // 生成一个解析器
        client.setParser(new XMLResponseParser());
        // 设置超时时间
        client.setConnectionTimeout(1000);
        SolrQuery solrQuery = new SolrQuery("*:*");
//        solrQuery.addFilterQuery("keyword:'北京'");
//        solrQuery.setSort("id",SolrQuery.ORDER.asc);
        solrQuery.addFilterQuery("cityId:2");
        solrQuery.setStart(0);
        solrQuery.setRows(6);
        QueryResponse response = client.query(solrQuery);

        List<ItripHotelVO> list = response.getBeans(ItripHotelVO.class);
        for (ItripHotelVO itripHotelVO : list) {
            System.out.println(itripHotelVO.getHotelName() +":" +itripHotelVO.getAddress());
        }
    }

}
