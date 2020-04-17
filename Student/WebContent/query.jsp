<%@page import="com.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 显示个人详细信息 -->

<%
	Student student=(Student)request.getAttribute("student");
%>
<form action="UpdateStudentServlet" method="post">
学号<input type="text" name="sno" value="<%=student.getSno()%>" readonly="readonly"/><br/>
姓名<input type="text" name="sname" value="<%=student.getSname()%>" /><br/>
年龄<input type="text" name="sage" value="<%=student.getSage()%>" /><br/>
地址<input type="text" name="saddress" value="<%=student.getSaddress()%>" /><br/>
<input type="submit" value="提交"/>
</form>
<p>注意：在单元格里输入修改内容（学号不可修改）</p>


</body>
</html>