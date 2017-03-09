select table_name from user_tables;

 
select e.empno  	as emp_empno,
	   e.ename  	as emp_ename,
	   e.job    	as emp_job, 
	   e.mgr		as emp_mgr, 
	   e.hiredate   as emp_hiredate,
	   e.sal		as emp_sal, 
	   e.comm   	as emp_comm,
	   e.deptno 	as emp_deptno,
	   d.deptno     as dept_deptno, 
	   d.dname  	as dept_dname,
	   d.loc		as dept_loc 
  from emp e left outer join dept d 
    on e.deptno =d.deptno;

select * from city where country_code='KOR';
create table country ( 							
	code 			char(3 char),						
	name 			char(52 char),						
	continent		char(20 char)	default 'Asia',		
	region			char(26 char),						
	surface_area		number(10,2)	default '0.00',	
	indep_year		number(6),							
	population		number(11)		default 0,			
	life_expectancy	number(3,1),						
	gnp				number(10,2),							
	gnp_old			number(10,2),
	local_name		char(45 char),						
	government_form	char(45 char),
	head_of_state		char(60 char)	default null,
	capital			number(11)		default null,
	code2			char(2  char),
	constraint ck_continent check (continent in ('Asia','Europe','North America','Africa','Oceania','Antarctica','South America')),
	constraint pk_country primary key (code)
);

/*
 * City
 */
create table city (
	id				number(11)		not null,
	name			char(35 char),
	country_code 	char(3 char),
	district		char(20 char),
	population		number(11)		default 0,
	constraint 		pk_city primary key (id),
	constraint 		fk_country foreign key (country_code) references country(code) 
);
select * from city c left outer join country t
on c.country_code = t.code;


select  c1.id				as city_id,
		c1.name				as city_name,
		c1.country_code		as city_country_code,
		c1.district			as city_district,
		c1.population		as city_population,
		c2.code 			as country_code,
		c2.name 			as country_name,	
	   c2.continent 		as country_continent,
	   c2.region			as country_region,
	   c2.surface_area		as country_surface_area,
	   c2.indep_year 		as country_indep_year,
	   c2.population 		as country_population,
	   c2.life_expectancy 	as country_life_expectancy,
	   c2.gnp				as country_gnp,
	   c2.gnp_old 			as country_gnp_old,
	   c2.local_name 		as country_local_name,
	   c2.government_form 	as country_government_form,
	   c2.capital 			as country_capital,
	   c2.code2 			as country_code2		
  from city c1 left outer join country c2
    on c1.country_code = c2.code
    where c1.country_code ='KOR';
	
	
--
--City Paging
--

select count(*) from city;

Select *
  from city
  order by id
  offset 40 rows 
  fetch next 17 rows only;
  
  	
	
select	c1.code 			as country_code,
		c1.name 			as country_name,	
	   c1.continent 		as country_continent,
	   c1.region			as country_region,
	   c1.surface_area		as country_surface_area,
	   c1.indep_year 		as country_indep_year,
	   c1.population 		as country_population,
	   c1.life_expectancy 	as country_life_expectancy,
	   c1.gnp				as country_gnp,
	   c1.gnp_old 			as country_gnp_old,
	   c1.local_name 		as country_local_name,
	   c1.government_form 	as country_government_form,
	   c1.capital 			as country_capital,
	   c1.code2 			as country_code2,		
		c2.id				as city_id,
		c2.name				as city_name,
		c2.country_code		as city_country_code,
		c2.district			as city_district,
		c2.population		as city_population
  from country c1 left outer join city c2
    on c1.code = c2.country_code
   where c1.code ='KOR';


select count(*)
  from city
 where country_code='KOR';
--
-- selectPage
--where로 한국만 조회해도, where 없어도 2번째에서 시작해서 3줄만 나오는 건 똑같음 
select *
  from city
-- where country_code='KOR'
 offset 2 rows 
 fetch next 3 rows only;
 
 
 
 --
 --selectPageWithCountry
 --
select *
  from city c1 left outer join country c2
    on c1.country_code=c2.code 
 where c1.country_code = 'KOR'
 order by id
 offset 2 rows 
 fetch next 3 rows only;
 
 
 
 --
 --CountryMapper.selectPage
 --
 select *
 from COUNTRY 
 order by code 
 offset 2 rows	
 fetch next 3 rows only;
 
 
 
 select * 
 from city 
 where country_code='AGO';
 
 select *
 from city
 where country_code='AIA';
 
 
 select *
 from city
 where country_code='ALB';
 --
 --CountryMapper.selectPageWithCity
 --
select *
from country c1 left outer join city c2	
on c1.code =c2.country_code
order by c1.code
offset 2 rows
fetch next 3 rows only;



select d.deptno     as dept_deptno, 
	   d.dname  	as dept_dname,
	   d.loc		as dept_loc, 
	   e.empno  	as emp_empno,
	   e.ename  	as emp_ename,
	   e.job    	as emp_job, 
	   e.mgr		as emp_mgr, 
	   e.hiredate   as emp_hiredate,
	   e.sal		as emp_sal, 
	   e.comm   	as emp_comm,
	   e.deptno 	as emp_deptno
 from dept d left outer join emp e
 on d.deptno=e.deptno; 
 
 
 
  
	
