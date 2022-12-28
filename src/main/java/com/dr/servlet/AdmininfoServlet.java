package com.dr.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dr.service.impl.AdmininfoServiceImpl;

@WebServlet("/admininfo")
public class AdmininfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		if(method.equals("login")) {
			login(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void login(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		int result=AdmininfoServiceImpl.searchByUsernameAndPsw(username, password);
		if(result==1) {
			//successfully login into the system
			
		}else if(result==0) {
			//unsuccessfully login into the system
			
		}
 	}
}
