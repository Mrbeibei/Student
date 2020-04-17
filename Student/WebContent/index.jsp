<%@page import="com.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全部信息</title>
</head>
<body>
<%
	//判断是否增加成功标识
	String error=(String)request.getAttribute("error");
	if(error!=null){
		switch(error){
		case "noadderror" :
		   out.print("增加成功");
		   break; //可选
		case "adderror" :
		   out.print("增加失败");
		   break; //可选
		case "nodeleteerror" :
			out.print("删除成功");
		   break; //可选
		case "deleteerror" :
			out.print("删除失败");
		   break; //可选
		case "noupdateerror" :
			out.print("修改成功");
		   break; //可选
		case "updateerror" :
			out.print("修改失败");
		   break; //可选
		//你可以有任意数量的case语句
		//default : //可选
		   //语句
	}
}
%>


<table border="1">
	<tr>
		<th>学号</th>
		<th>姓名</th>
		<th>年龄</th>
		
		<th>操作</th>
		
	</tr>
	<%
		@SuppressWarnings("unchecked")
		List<Student> students=(List<Student>)request.getAttribute("students");
		for(Student student: students){
	%>
	
	<tr>
		<td><a href="QueryStudentBySnoServlet?sno=<%=student.getSno()%>"><%=student.getSno() %></a></td>
		<td><%=student.getSname() %></td>
		<td><%=student.getSage() %></td>
		<td><a href="DeleteStudentServlet?sno=<%=student.getSno()%>">删除</a></td>
	</tr>
	<%
			}
	%>			
	
</table>

<a href="add.jsp">新增</a>


</body>
</html>