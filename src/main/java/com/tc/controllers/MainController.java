package com.tc.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tc.utils.LogUtils;

@Controller
public class MainController {
	@RequestMapping(value= {"/index","/"})
	public String index(){
		System.out.println("index!!!");
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		LogUtils.info("登陆");
		return "welcome";
	}
}
