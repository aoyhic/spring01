package com.example.city.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.City;
import com.example.mapper.CityMapper;
import com.example.util.Pagination;

@Service
public class CitySearchService {
	static Log log = LogFactory.getLog(CitySearchService.class);
	
	@Autowired
	CityMapper cityMapper;
	
	//getListAll하면 매퍼를 사용해서 리스트를 만들어서 리턴해줘야함. 컨츄리 정보 없이 조회한다는 뜻. 
	public List<City> getListAll(){
		log.info("getListAll()");
		return getListAll(false);
	}
	//컨츄리 정보까지 가져온 시티정보를 원하는구나? 파라매터를 넣어줬으니 
	public List<City> getListAll(boolean withCountry){
		log.info("getListAll("+ withCountry +")");
		List<City> list = null;
		if (withCountry)
			list = cityMapper.selectAllWithCountry();
		else
			list = cityMapper.selectAll();
		return list;
	}
	
	//getPage면 어떤 페이지를 받는지 모르니까 페이지넘버로 받음 
	public Map<String,Object> getPage(int pageNo){
		return getPage(pageNo, false);
	}
	//오버로딩 할 수 있는 조건이 갖춰졌고, 이름을 같이 쓸 수 있는 장점이 있다. 
	public Map<String,Object> getPage(int pageNo, boolean withCountry){
		//넘겨줘야 할 내용 1. 페이지네이션 정보 
		Pagination paging = new Pagination();
		paging.setTotalItem(cityMapper.selectTotalCount());
		paging.setPageNo(pageNo);
		
		//초기화
		List<City> list = null;
		
		if(withCountry)
		list =  cityMapper.selectPageWithCountry(paging);
		else
			list = cityMapper.selectPage(paging);
		//
		Map<String, Object> map = new HashMap<>();
		map.put("citys",list);
		map.put("paging", paging);
		
		return map;
	}
	
	//씨티 아이디를 넘겨주면 아이디 정보를 리턴하는 것 
	public City getCityById(int id){
		log.info("getCityById=("+id+")");
		return getCityById(id, false);
	}
	
	public City getCityById(int id, boolean withCountry){
		log.info("getCityById("+id+","+ withCountry+")");
		City city = null;
		if(withCountry)
			city = cityMapper.selectByIdWithCountry(id);
		else
			city = cityMapper.selectById(id);
		return city;
	}
	
	
}
