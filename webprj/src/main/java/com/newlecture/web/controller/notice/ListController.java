package com.newlecture.web.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ListController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
//		ModelAndView mv = new ModelAndView("notice/list");
		ModelAndView mv = new ModelAndView("notice.list");	//타일즈를 사용하기 위함.
		
		
		return mv;
	}

}
