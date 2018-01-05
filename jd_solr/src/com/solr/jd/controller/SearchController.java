package com.solr.jd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.solr.jd.pojo.Result;
import com.solr.jd.service.SearchService;

@Controller
@RequestMapping("search")
public class SearchController {
	@Autowired
	private SearchService searchService;

	/**
	 * 实现搜索功能
	 * 
	 * @param model
	 * @param queryString
	 * @param catalog_name
	 * @param price
	 * @param sort
	 * @param page
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("list")
	public String queryProduct(Model model, String queryString, String catalog_name, String price, String sort,
			Integer page) throws Exception {
		// 根据条件搜索
		Result result = this.searchService.queryProduct(queryString, catalog_name, price, sort, page);

		// 把结果集放到模型中
		model.addAttribute("result", result);

		// 搜索条件数据回显
		model.addAttribute("queryString", queryString);
		model.addAttribute("catalog_name", catalog_name);
		model.addAttribute("price", price);
		model.addAttribute("sort", sort);
		model.addAttribute("page", page);

		return "product_list";
	}
}
