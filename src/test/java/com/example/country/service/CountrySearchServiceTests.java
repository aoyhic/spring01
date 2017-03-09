package com.example.country.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Country;



@SpringBootTest
@RunWith(SpringRunner.class)
public class CountrySearchServiceTests {

	@Autowired
	CountrySearchService service;
	
	@Test
	public void test00_confirmService(){
		System.out.println("service="+service);
	}
	
	@Test
	public void test01_getListAll(){
		List<Country> list = service.getListAll();
		for (Country c:list)
			System.out.println(c);
	}
	@Test
	public void test01_getListAll_withCity(){
		List<Country> list=service.getListAll(true);
		
		//향상된 for문을 쓰다가 일반 포문을 써봄 
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
	}
	
	@Test
	public void test02_getPage(){
		Map<String, Object> map = service.getPage(2);
		System.out.println(map.get("countrys"));
		System.out.println(map.get("paging"));
	}
	
	@Test
	public void test02_getPage_withCity(){
		Map<String, Object> map = service.getPage(1, true);
		
		List<Country> list = (List<Country>)map.get("countrys"); 
		for (Country c: list)
			System.out.println(c);
		
		System.out.println(map.get("paging"));
	}
	 

	@Test
	public void test03_getCountryByCode(){
		Country c = service.getCountryByCode("KOR");
		System.out.println(c);
	}
	
	@Test
	public void test03_getCountryByCode_withCity(){
		Country c=service.getCountryByCode("KOR", true);
		System.out.println(c);
	}
}
