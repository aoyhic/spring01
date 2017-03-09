package com.example.country;

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

import com.example.country.service.CountrySearchService;
import com.example.domain.Country;
import com.example.exception.NotFoundRuntimeException;

@Controller
@RequestMapping("/country") //요청이 컨트리로 들어오면 컨트리서비스컨트롤러가 실행된다고.
public class CountrySearchController {
	
	static Log log=LogFactory.getLog(CountrySearchController.class);
	
	@Autowired
	CountrySearchService countrySearchService;
	//컨트롤러는 웹 요청을 받아서 그 요청에 따라 처리하는 것. 컨츠리/리스트는 조회해 온 데이터를 넣어놓음. 
	
	@GetMapping("/list")
	public String getListAll(Model model){
		log.info("######getList()###########");
		
		List<Country> list = countrySearchService.getListAll();
		model.addAttribute("list",list); //모델에 저장해놓으면 리퀘스트에 들어감. 그럼 리퀘스트가 알아서 찾아감.
		
		//country/list로 들어오면 겟리스트all이 수행됨  뷰 이름임. 논리적인 뷰이름을 리턴하면 물리적인 뷰이름을 리턴해줌 
		return "country/list";
	}
	//String으로 하는 이유는 논리적인 뷰를 리턴하기 위함. pageNo는 사용자가 요청하는 것. {pageNo}를 파라미터로 리턴할 때 int pageNo로 넣어달라는 의미로 @pathvariable을 쓴 것임 
	@GetMapping("/page/{pageNo}")
	public String getPage(@PathVariable int pageNo, Model model){
		log.info("getPage("+ pageNo + ")");
		
		//
		Map<String, Object> page = countrySearchService.getPage(pageNo);
		model.addAttribute("page",page); 
		
		return "country/page";
	}
	
	
	@GetMapping("/item/{code}")
	public String getItem(@PathVariable String code,Model model){
		log.info("getItem("+ code + ")");
		
		try{
		Country c =countrySearchService.getCountryByCode(code,true);
		model.addAttribute("country", c);
		} catch(NotFoundRuntimeException e){
			model.addAttribute("error", e.getMessage()); //에러났으면 모델에 달아놓으라는 뜻. 에러가 리퀘스트가 달려있어서 에러처리가 가능해짐.
		}
		
		return "country/item";
	}
	
	
}

