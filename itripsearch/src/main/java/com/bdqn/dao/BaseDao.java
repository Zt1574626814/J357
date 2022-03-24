package com.bdqn.dao;

import com.bdqn.entity.ItripHotelVO;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

public class BaseDao<T> {

    public static String url = "http://localhost:8080/solr/hotelCore/";

    HttpSolrClient httpSolrClient;

    public BaseDao() {
        httpSolrClient = new HttpSolrClient(url);
        // 生成一个解析器
        httpSolrClient.setParser(new XMLResponseParser());
        // 设置超时时间
        httpSolrClient.setConnectionTimeout(3000);
    }

    public List<T> getList(SolrQuery query) throws SolrServerException, IOException {
        QueryResponse response = httpSolrClient.query(query);
        List<T> list = (List<T>) response.getBeans(ItripHotelVO.class);
        return list;
    }
}
