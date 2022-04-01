package com.bdqn.dao;

import com.bdqn.common.Page;
import com.bdqn.entity.ItripHotelVO;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

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

    /**
     * 根据条件分页搜索
     * @param query solr查询条件
     * @param index 当前页
     * @param pageSize 每页条数
     * @return page分页对象
     * @throws SolrServerException solr服务异常
     * @throws IOException IO流异常
     */
    public Page<ItripHotelVO> getListPage(SolrQuery query, int index, int pageSize) throws SolrServerException, IOException {
        // 设置起始位置
        query.setStart((index - 1) * pageSize);
        // 设置行数
        query.setRows(pageSize);
        // solr客户端获取查询请求
        QueryResponse queryResponse = httpSolrClient.query(query);
        // 查询
        List<ItripHotelVO> list = queryResponse.getBeans(ItripHotelVO.class);
        SolrDocumentList solrDocuments = queryResponse.getResults();
        // 一共有多少条数据
        Page<ItripHotelVO> page = new Page<>(index,pageSize,new Long(solrDocuments.getNumFound()).intValue());
        // 数据装到page对象中
        page.setRows(list);
        return page;
    }

}
