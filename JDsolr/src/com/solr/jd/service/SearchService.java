package com.solr.jd.service;

import com.solr.jd.pojo.Result;

public interface SearchService {

	Result queryProduct(String queryString, String catalog_name, String price, String sort, Integer page) throws Exception;

}
