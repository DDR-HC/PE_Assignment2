package com.dr.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.dr.entity.Student;
import com.dr.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		if(method.equals("add")) {
			addStudent(request,response);
		}else if(method.equals("search")) {
			searchStudent(request, response);
		}else if(method.equals("delete")) {
			deleteStudent(request, response);
		}else if(method.equals("update")) {
			updateStudent(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void addStudent(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String SID=request.getParameter("SID");
		String SName=request.getParameter("SName");
		String Gender=request.getParameter("Gender");
		String Passport=request.getParameter("Passport");
		String Programme=request.getParameter("Programme");
		String Intake=request.getParameter("Intake");
		String Regtime=request.getParameter("Regtime");
		String Nationality=request.getParameter("Nationality");
		String phone=request.getParameter("phone");
		int result= StudentServiceImpl.addStudent(SID, SName, Gender, Passport, Programme, Intake, Regtime, Nationality, phone);
		if(result==1) {
			//successfully add new students
			System.out.println("successfully add new students!");
			request.setAttribute("result", Passport);
			request.getRequestDispatcher("searchresult.jsp").forward(request, response);
		}else if(result==0) {
			//unsuccessfully add new students
			System.out.println("fail to add new students!");
			response.sendRedirect("errorPage.html");
		}
	}
	
	private void searchStudent(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String IC=request.getParameter("Passport");
		Student result=StudentServiceImpl.searchByIC(IC);
		System.out.println("------------------------------------------------------");
		System.out.println(result.getSID());
		System.out.println(result.getIntake());
		System.out.println(result.getGender());
		System.out.println(result.getNationality());
		System.out.println(result.getPassport());
		//successfully find the student
		if(result.getSID()!=null) {
			//successfully find the student information
			System.out.println("sucessfully find the student information!");
			request.setAttribute("result", result.getPassport());
			request.getRequestDispatcher("searchresult.jsp").forward(request, response);
		}else {
			//not find the student information
			System.out.println("not find the student information");
		}
	}
	
	private void deleteStudent(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String SID=request.getParameter("SID");
		int result=StudentServiceImpl.deleteBySID(SID);
		if(result==1) {
			//successfully delete the student
			request.getRequestDispatcher("afterlogin.jsp").forward(request, response);
		}else if(result==0) {
			//fail to delete the student
			
		}
	}
	
	private void updateStudent(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String SID=request.getParameter("SID");
		String SName=request.getParameter("SName");
		String Gender=request.getParameter("Gender");
		String Passport=request.getParameter("Passport");
		String Programme=request.getParameter("Programme");
		String Intake=request.getParameter("Intake");
		String Regtime=request.getParameter("Regtime");
		String Nationality=request.getParameter("Nationality");
		String phone=request.getParameter("phone");
		int result=StudentServiceImpl.updateInfo(SID, SName, Gender, Passport, Programme, Intake, Regtime, Nationality, phone);
		if(result==1) {
			//successfully update the student information
			
			
		}else if(result==0) {
			//fail to update the student information
			
			
		}
	}
}
