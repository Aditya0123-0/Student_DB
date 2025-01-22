<%@page import="com.jsp.springmvc.studentdb.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Student student =(Student) request.getAttribute("student");

%>
<h1>Enter values to be Updated</h1>
<form action="update-student" method="post">
<input type="number" value="<%= student.getStudentId() %>" name="studentId" readonly="readonly">
<input type="text" value="<%= student.getStudentName() %>" name="studentName" readonly="readonly">
<input type="text" value="<%= student.getEmail() %>" name="email">
<input type="number" value="<%= student.getAge()%>" name="age">
<input type="number" value="<%= student.getMarks() %>" name="marks">
<input type="submit" value="Update">

</body>
</html>