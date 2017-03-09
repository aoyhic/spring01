package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Dept;
import com.example.exception.NotFoundRuntimeException;
import com.example.util.Pagination;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DeptMapperTests {

	@Autowired
	DeptMapper mapper;
	
	@Test
	public void test00_confirm(){
		System.out.println("mapper="+mapper);
	}
	
	@Test
	public void test01_selectAll(){
		List<Dept> depts = mapper.selectAll();
		for(Dept d:depts)
			System.out.println(d);
	}
	@Test
	public void test01_selectAllWithEmp(){
		List<Dept> depts = mapper.selectAllWithEmp();
		
		for(Dept d:depts)
			System.out.println(d);
	}
	@Test
	public void test02_selectPage(){
		Pagination paging=new Pagination();
		paging.setTotalItem(mapper.selectToTalCount());
		paging.setPageNo(1);
		List<Dept> list =mapper.selectPage(paging);
		for (Dept d : list)
			System.out.println(d);
	}
	
	@Test
	public void test02_selectPageWithEmp(){
		Pagination paging = new Pagination();
		paging.setTotalItem(mapper.selectToTalCount());
		paging.setPageNo(1);
		
		List<Dept> list = mapper.selectPageWithEmp(paging);
		for (Dept d:list)
			System.out.println(d);
	}
	
	@Test
	public void test03_selectByDeptno(){
		Dept dept = mapper.selectByDeptno(20);
		if(dept == null)
			throw new NotFoundRuntimeException("Dept가 없습니다.");
		System.out.println(dept);
	}
	
	@Test
	public void test03_selectByDeptnoWithEmp(){
		Dept dept = mapper.selectByDeptnoWithEmp(10);
		if(dept == null)
			throw new NotFoundRuntimeException("Dept가 없습니다.");
		System.out.println(dept);
	}
}
