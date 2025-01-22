<%@page import="com.jsp.springmvc.studentdb.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% List<Student> stuList = (List) request.getAttribute("studentList"); %>

<table border="2px">
<tr>
<th>Student ID</th>
<th>Student Name</th>
<th>Email</th>
<th>Age</th>
<th>Marks</th>
<th>Update</th>
<th>Delete</th>
</tr>

<%
for(Student list:stuList){
%>
<tr>
<td><%= list.getStudentId()%></td>
<td><%= list.getStudentName() %></td>
<td><%= list.getEmail() %></td>
<td><%= list.getAge() %></td>
<td><%= list.getMarks() %></td>
<td><a href="find-student-by-id?studentId=<%=list.getStudentId() %>">UPDATE</a></td>
<td><a href="delete-student-by-id?studentId=<%=list.getStudentId() %>">DELETE</a></td>

<%} %>
</tr>
</table>

<h2><a href="index.jsp">Go to Dashborad..</a></h2>
</body>
</html>