package com.example.mapper;



import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.City;
import com.example.domain.Country;
import com.example.exception.NotFoundRuntimeException;
import com.example.util.Pagination;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CityMapperTests {

	@Autowired
	CityMapper cityMapper;
	
	@Autowired
	CountryMapper countryMapper;
	
	@Test
	public void test01_confirmCity(){
		System.out.println("cityMapper="+cityMapper);
	}
	
	@Test
	public void test01_confirmCountry(){
		System.out.println("countryMapper="+countryMapper);
	}
	
	@Test
	public void test01_selectAll(){
		List<City> list = cityMapper.selectAll();
		
		for (City c:list)
			System.out.println(c);
	}
	
	@Test
	public void test01_selectAllWithCountry(){
		List<City> citys = cityMapper.selectAllWithCountry();
		for (City t:citys)
			System.out.println(t);
	}
	
	@Test
	public void test02_selectPage(){
		Pagination paging = new Pagination();
		paging.setTotalItem(cityMapper.selectTotalCount());
		paging.setPageNo(1000); //1000페이지는 없으므로 맨 마지막 페이지가 나온다.
		
		List<City> list =cityMapper.selectPage(paging);
		
		for (City c:list)
			System.out.println(c);
	}
	
	@Test
	public void test02_selectPageWithCountry(){
		Pagination paging = new Pagination();
		paging.setTotalItem(cityMapper.selectTotalCount());
		paging.setPageNo(2);
	
		List<City> citys = cityMapper.selectPageWithCountry(paging);
		for (City t:citys)
			System.out.println(t);
	}
	
	
	//찾는 값이 없으면 null 나온다. 
	@Test
	public void test03_selectById(){
	City city = cityMapper.selectById(100);
	
	
//	if (city == null){
//		throw new NotFoundRuntimeException("city 정보가 없습니다.");
//	}
	System.out.println("city="+city);
	}
	
	@Test
	public void test03_selectByIdWithCountry(){
	City city = cityMapper.selectByIdWithCountry(10);
	
	
	if (city == null){
		throw new NotFoundRuntimeException("city 정보가 없습니다.");
	}
	System.out.println(city);
	}
	
	@Test
	public void test04_insert(){
		City city = new City();
		city.setName("xxx");
		city.setCountryCode("KOR");
		
		//컨트리 코드가 있는지 우선 확인해보고. city에서 고려해야하는건 나라코드가 진짜 있냐? 여서 이걸 찾는 걸 먼저 수행하는 것. country에서 고려하는건 부모테이블에 이 코드인 kor이란 코드가 있냐는 것. 
		Country country = countryMapper.selectByCode(city.getCountryCode());
		
		//널이면 끝내라 
		if(country==null){
				System.out.println("error="+"해당 countryCode가 없습니다.");
				return; 		
		}
		int cnt = cityMapper.insert(city); //이것도 insert된 갯수로 찾아오기 때문에  int를 써주는 것 
		
		System.out.println(cityMapper.selectById(city.getId()));
	}
	
	
	
}
