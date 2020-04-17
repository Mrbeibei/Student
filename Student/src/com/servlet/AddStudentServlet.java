package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.entity.Student;
import com.service.StudentService;

/**
 * Servlet implementation class AddStudentServlet
 */

//AddStudentServlet处理增加的Servlet
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int sno = Integer.parseInt(request.getParameter("sno"));
		String sname = request.getParameter("sname");
		int sage =Integer.parseInt( request.getParameter("sage"));
		String saddress = request.getParameter("saddress");
		Student student=new Student(sno,sname,sage,saddress);
		
		//dao层为此层服务。本层需要给dao层提高参数
		//StudentDao studentDao=new StudentDao();
		
		StudentService service=new StudentService();
		boolean result = service.addStudent(student);
		if(!result) {
			//response.getWriter().print("增加失败");
			request.setAttribute("error", "adderror");
		}else {
			request.setAttribute("error", "noadderror");
		}
		request.getRequestDispatcher("QueryAllStudentServlet").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
