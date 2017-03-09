package com.example.util;

import org.junit.Test;

public class PagenationTests {
	@Test
	public void test01(){
		Pagination paging = new Pagination();
		
		paging.setTotalItem(4079); //select count(*) from city
		paging.setPageNo(19); //1 page로 시작 
		
		System.out.println("itemsPerPage="+paging.getItemsPerPage());
		System.out.println("totalPage="+paging.getTotalPage());
		System.out.println("firstItem="+paging.getFirstItem());
		System.out.println("lastItem="+paging.getLastItem());
		}
	
	@Test
	public void test02_selectPage(){
		Pagination paging = new Pagination();
		paging.setTotalItem(4079);
		paging.setPageNo(10);
		
		
		
		for (int i=1; i<=paging.getTotalPage(); i++){
			paging.setPageNo(i);
			System.out.println("pageNo=" + paging.getPageNo() +
							", firstItem="+paging.getFirstItem() +
							",lastItem=" +paging.getLastItem() +
							",offset=" +(paging.getFirstItem()-1) +
							",itemPerPage=" +paging.getItemsPerPage()
							);
		}
	}
}
