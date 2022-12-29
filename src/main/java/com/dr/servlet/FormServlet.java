package com.dr.servlet;

import java.io.IOException;
import com.dr.entity.Form;
import com.dr.service.impl.FormServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		if(method.equals("check")) {
			check(request, response);
		}else if(method.equals("add")) {
			addFormBySID(request, response);
		}else if(method.equals("update")) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void check(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String SID=request.getParameter("SID");
		Form result=FormServiceImpl.searchBySID(SID);
		if(result.getFID()==0) {
			//there isn't an existing form stored in the database for that particular student
			request.setAttribute("SID", SID);
			request.getRequestDispatcher("addform.jsp").forward(request, response);
		}else if(result.getFID()!=0) {
			//there is an existing form stored in the database for that particular student
			request.setAttribute("SID", SID);
			request.getRequestDispatcher("updateform.jsp").forward(request, response);
		}
	}
	
	private void addFormBySID(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String SID=request.getParameter("SID");
		String Q1=request.getParameter("Q1");
		String Q2=request.getParameter("Q2");
		String Q3=request.getParameter("Q3");
		String Q4=request.getParameter("Q4");
		String Q5=request.getParameter("Q5");
		int result=FormServiceImpl.addNewForm(Q1, Q2, Q3, Q4, Q5, SID);
		if(result==1) {
			//succcessfully add the new form
			System.out.println("successfully add the new form");
		}else if(result==0) {
			System.out.println("fail to add the new form");
		}
	}
}
