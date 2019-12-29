package com.tc.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController{

	@Override
	public String getErrorPath() {
		return "/error";
	}
	
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request){
		
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		System.out.println(statusCode+" error found");
        if(statusCode == 500){
            return "/error/500";
        }else if(statusCode == 404){
            //对应的是/error/404.html、/error/404.jsp等，文件位于/templates下面
            return "/error/404";
        }else if(statusCode == 403){
            return "/error/403";
        }else{
            return "/500";
        }

	}
	
}
