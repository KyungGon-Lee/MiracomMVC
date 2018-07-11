<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1> 회원목록 <a href=registerform.do>가입</a>
<a href=/miracom>홈으로</a>
<br>
<table border=3>
<c:forEach var="mem" items="${lists}">
	<tr>
		<td>아이디 : ${mem.id}  </td>
		<td>이름 : ${mem.name}  </td>
		<td>성별 : ${mem.gender}  </td>
		<td>취미 : ${mem.hobby}  </td>
		<td><a href=deletemember.do?id=${mem.id}> 삭제 </a></td>
	</tr>
</c:forEach>
</table>
</h1>
</body>
</html>