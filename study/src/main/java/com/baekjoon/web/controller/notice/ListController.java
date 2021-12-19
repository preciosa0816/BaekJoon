package com.baekjoon.web.controller.notice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.baekjoon.web.entity.Notice;
import com.baekjoon.web.service.jdbc.JDBCNoticeService;

public class ListController implements Controller{
	private JDBCNoticeService noticeService;
	
	public void setNoticeService(JDBCNoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mv = new ModelAndView("notice.list");
		List<Notice> list =  noticeService.getList(1, "TITLE", "");
		mv.addObject("list",list);
		return mv;
	}

}


