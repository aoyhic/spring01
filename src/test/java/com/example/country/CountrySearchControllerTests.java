package com.example.country;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class CountrySearchControllerTests {

	//핸덤포트가 들어오는 어노테이션 
	@LocalServerPort
	int port;
	
	//웹브라우저처럼 동작함 
	@Autowired
	TestRestTemplate rest;
	
	
	@Test
	public void test00_port(){
		System.out.println("port="+port);
	}
	
	@Test
	public void test00_testRestTemplate(){
		System.out.println("rest="+rest);
	}
	
	@Test
	public void test01_getListAll(){
		String html = rest.getForObject("/country/list",String.class);
		//"country/list" url로 찾은 결과를 스트링으로 리턴받겠다는 뜻. 
		System.out.println(html);
	}
	
	@Test
	public void test02_getPage(){
		String html = rest.getForObject("/country/page/13",String.class);
		//"country/list" url로 찾은 결과를 스트링으로 리턴받겠다는 뜻. 
		System.out.println(html);
	}
	
	
	
	
	@Test
	public void test03_getItem(){
		String html = rest.getForObject("/country/item/KOR",String.class);
		//"country/list" url로 찾은 결과를 스트링으로 리턴받겠다는 뜻. 
		System.out.println(html);
	}
	
	@Test
	public void test03_getItem_NotFoundRuntimeException(){
		String html = rest.getForObject("/country/item/xxx",String.class);
		
		System.out.println(html);
	}
	
}
