package com.newlecture.web.controller.api;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@RestController("apiNoticeController")//이름을 이렇게 지정해주면 같은 파일일때 오류가 안남
@RequestMapping("/api/notice/")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	@RequestMapping("list")
	public Notice list() throws ClassNotFoundException, SQLException {
		
		
		List<Notice> list = service.getList(1, "TITLE", "");
		
		return list.get(0);
	}
}
