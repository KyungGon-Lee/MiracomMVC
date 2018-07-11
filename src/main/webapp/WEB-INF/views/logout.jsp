<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script>
	alert('logout 했습니다.');
	location.href = "/miracom/";
</script>

<%
	session.removeAttribute("id");
%>

</body>
</html>