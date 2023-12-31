package com.newlecture.web.controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;
import com.newlecture.web.service.jdbc.JDBCNoticeService;

public class ListController2 implements Controller{
	
	@Autowired
	private NoticeService noticeService;
	
	
//	public void setNoticeService(NoticeService noticeService) {
//		this.noticeService = noticeService;
//	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
//		ModelAndView mv = new ModelAndView("notice/list");
		ModelAndView mv = new ModelAndView("notice.list");	//타일즈를 사용하기 위함.
		
		List<Notice> list = noticeService.getList(1, "TITLE", "");
		mv.addObject("list",list);
		
		return mv;
	}

}
