package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchpageController {
	@RequestMapping(value="/searchpage" , method = {RequestMethod.POST,RequestMethod.GET})
	public String Searchpage() {
		return "searchpage";
	}
	
}



