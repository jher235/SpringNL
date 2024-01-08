package com.newlecture.web.controller.api;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@RestController("apiNoticeController")//이름을 이렇게 지정해주면 동일한 파일명이 있어도 오류가 안남
@RequestMapping("/api/notice/")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	@RequestMapping("list")
	public Notice list(@RequestParam(name="p", defaultValue = "1") String page) throws ClassNotFoundException, SQLException {
		//String p = request.getParameter("p");
		System.out.println("page: "+page);
		
		List<Notice> list = service.getList(1, "TITLE", "");
		
		return list.get(0);
	}
}
