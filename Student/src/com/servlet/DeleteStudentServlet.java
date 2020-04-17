package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.StudentService;

/**
 * Servlet implementation class DeleteStudentServlet
 */
public class DeleteStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int sno = Integer.parseInt(request.getParameter("sno"));
		StudentService service=new StudentService();
		boolean result = service.deleteStudent(sno);
		if(result) {
			request.setAttribute("error", "nodeleteerror");
		}else {
			request.setAttribute("error", "deleteerror");
			//response.getWriter().print("删除失败");
		}
		
		request.getRequestDispatcher("QueryAllStudentServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
