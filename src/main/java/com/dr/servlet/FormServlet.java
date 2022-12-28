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
		if(method.equals("search")) {
			searchBySID(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void searchBySID(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String SID=request.getParameter("SID");
		Form result=FormServiceImpl.searchBySID(SID);
		if(result.getFID()!=0) {
			//successfully find the form
			System.out.println("successfully find the form");
			request.setAttribute("result", result.getFID());
			//跳转到下一个页面中
			request.getRequestDispatcher("").forward(request, response);
		}else if(result.getFID()==0) {
			System.out.println("fail to find the form");
			request.setAttribute("SID", SID);
			////跳转到为学生注册的页面中
			request.getRequestDispatcher("").forward(request, response);
		}
	}
}
