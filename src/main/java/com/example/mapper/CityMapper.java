package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.domain.City;
import com.example.util.Pagination;

@Mapper
public interface CityMapper {
	/*
	 * 1. select 
	 */
	@Select("select count(*) from city")
	int selectTotalCount();

	@Select("select * from city")
	List<City> selectAll();
	List<City> selectAllWithCountry();
	@Select({
		"select *				",
		" from city				",
		" order by id			",
		" offset #{firstItem} -1 rows	",
		" fetch next #{itemsPerPage} rows only"
	})
	List<City> selectPage(Pagination paging);
	
	List<City> selectPageWithCountry(Pagination paging);
	
	@Select("select * from city where id=#{id}")
	City selectById(int id);
	City selectByIdWithCountry(int id);
	/*
	 * 2.insert
	 */
	int insert(City city); //빈으로 감싸서, 모델로 감싸서 넘김. insert된 갯수로 받아와야 하기 때문에 int로 씀 
	
	/*
	 * 3.update
	 */
	int updateById(City city); //primary key로 업데이트 하는건 반드시 있어야함 
	
	/*
	 * 4.delete
	 */
	@Delete("delete from city where id=#{id}")
	int deleteById(int id); //delete 할 때는 id만 있으면 delete 가능함. delete는 쿼리가 간단함. 
}
