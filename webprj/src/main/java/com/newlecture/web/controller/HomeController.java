package com.newlecture.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping("index")
	@ResponseBody//리턴값을 그냥 사용자에게 보냄. 출력시킴.
	public String index(HttpServletResponse response) {
		
		
		return "hello";
//		return "root.index";
	}
	

}






//@Controller
//public class IndexController {
//	
//	@RequestMapping("/index")
//	public void aaaa() {
//		System.out.println("aa");
//		System.out.println("aa");
//		System.out.println("aa");
//		System.out.println("aa");
//		System.out.println("aa");
//		System.out.println("aa");
//	}
//	
//
//}



//public class IndexController implements Controller{
//
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		// TODO Auto-generated method stub
//		
//		
////		ModelAndView mv = new ModelAndView();
//		
//		ModelAndView mv = new ModelAndView("root.index");
//
//		mv.addObject("data","Hello Spring MVC!! ");
////		mv.setViewName("/WEB-INF/view/index.jsp");//절대경로
////		mv.setViewName("WEB-INF/view/index.jsp");//상대경로
//		
//		return mv;
//		
//	}
//
//}
