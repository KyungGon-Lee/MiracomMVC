<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>  
<!-- 이 태그를 써야 반복적인거 처리 가능 -->
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<!-- register.do로 해야됨 -->
<form action="register.do" method="get">
아이디 : <input type="text" name="id"><br/>
패스워드 : <input type="password" name="pwd"><br/>
이름:<input type="text" name="name"><br/>
성별:<input type="radio" value="man" name="gender">남자
<input type="radio" value="woman" name="gender">여자<br/>
취미:
<input type="checkbox" value="운동 " name="hobby">운동
<input type="checkbox" value="영화" name="hobby">영화
<input type="checkbox" value="여행 " name="hobby">여행
<input type="checkbox" value="게임" name="hobby">게임
<input type="checkbox" value="독서" name="hobby">독서
<input type="checkbox" value="낚시 " name="hobby">낚시<br/>
<input type="submit" value="보내기"/> 
<input type="reset" value="다시입력"/>
</form>


</body>
</html>