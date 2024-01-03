package com.newlecture.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IndexController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
//		ModelAndView mv = new ModelAndView();
		
		ModelAndView mv = new ModelAndView("index");

		mv.addObject("data","Hello Spring MVC!!");
//		mv.setViewName("/WEB-INF/view/index.jsp");//절대경로
//		mv.setViewName("WEB-INF/view/index.jsp");//상대경로
		
		return mv;
		
	}

}
