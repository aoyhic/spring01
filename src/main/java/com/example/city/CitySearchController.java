package com.example.city;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.city.service.CitySearchService;
import com.example.domain.City;
import com.example.exception.NotFoundRuntimeException;

@Controller
@RequestMapping("/city") //부모url
public class CitySearchController {
	static Log log = LogFactory.getLog(CitySearchService.class);
	@Autowired
	CitySearchService citySearchService;
	
	@GetMapping("/list")
	public String getListAll(Model model){
		
		List<City> list = citySearchService.getListAll(true);
		model.addAttribute("list",list);
		return "city/list";
	}
	
	@GetMapping("/page/{pageNo}")
	public String getPage(@PathVariable int pageNo, Model model){
		Map<String,Object> page = citySearchService.getPage(pageNo);
		model.addAttribute("page", page);
		
		
		return "city/page";
		
		
	}
	
	@GetMapping("/item/{id}")
	public String getItemById(@PathVariable int id, Model model){
		log.info("getItem("+id+")");
		
			//원래 try/catch만들었는데 더 간략하게 하기 위해, null리턴되도 상관없도록 수정함.
			City city = citySearchService.getCityById(id,true);
			model.addAttribute("city", city);
		
		return "city/item";
		
	}
}
