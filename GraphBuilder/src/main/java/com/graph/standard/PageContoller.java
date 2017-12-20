package com.graph.standard;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController 
public class PageContoller {
	@RequestMapping("/")
	public ModelAndView root(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}
}
