package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeleteActionController {
	@RequestMapping(value="/deleteAction", method=RequestMethod.GET)
	public String UpdateAction() {
		return "deleteAction";
	}
}
