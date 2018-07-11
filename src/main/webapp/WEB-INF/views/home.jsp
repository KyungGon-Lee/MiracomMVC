<!DOCTYPE html>
  <head>
    <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" 
    integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" 
    crossorigin="anonymous">
    <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <meta charset="utf-8">

    <title></title>
  </head>
  <body>

   	<h1>홈 페 이 지</h1><br>
    <img src=resources/bono.jpg width="20%" height="20%" class="fa-spin"><br>
    <br><br><br><br><br>
      username : <input type=text id=id><br>
      pwd : <input type=password id=pwd><br>
      <button id=login>login</button>

      <div>
        오늘의 날씨(서울)<br>
        <table border=1>
          <tr>
            <td> 날씨 </td>
            <td><span id=weather></span></td>
          </tr>
          <tr>
            <td> 온도 </td>
            <td><span id=temp></span></td>
          </tr>
          <tr>
            <td> 습도 </td>
            <td><span id=humidity></span></td>
          </tr>
        </table>
      </div>
      <div>
         오늘의 날씨(해외) <br>
         <table border="1">
            <tbody><tr>
               <td> 날씨 </td>
               <td>  <span id="weather2"></span>   </td>
            </tr>

            <tr>
               <td> 온도 </td>
               <td>  <span id="temp2"></span>   </td>
            </tr>
            <tr>
                <td> 습도 </td>  <td>  <span id="humidity2"></span>   </td>
            </tr>
         </tbody></table>
      </div>
      <a href=registerform>회원가입</a>

<script>
function displayWeather(lat, lon, weather, temp, humidity){
 var url = "http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&APPID=342bd9672f19bbc63b63ec3b629cb610";
    $.ajax({
    url:url,
    success:function(data){
      $(weather).html(data.weather[0].description);
      $(temp).html(data.main.temp);
      $(humidity).html(data.main.humidity);
    }
  });
}
  $(document).ready(function() {
    displayWeather(32, 20, "#weather", "#temp", "#humidity");
    displayWeather(52, 40, "#weather2", "#temp2", "#humidity2")
	 
	   $("#login").click( function() {
		   var id = $('#id').val();
		   var pwd = $('#pwd').val();
		   var http = "login.do?id=" + id + "&pwd=" + pwd;
		   // 여기선 login.jsp가아니라 login.do로 해야된다
		   console.log(http);
		   $.ajax({
	            url: http,
	            dataType:'json',
	            error: function(data) {
	            	alert("ERROR");
	            }, // 이거 브라우저에서는 되는데 컴파일러는 안됨 ㅠㅠ
	            success:function(data){
	            	if ( data.msg == "ok")
	            		alert("OK"),
	            		location.href = "/miracom/service.do";
	            	else {
	            		alert('id/pwd 확인');
	            		$('#id').val("");
	            		$('#pwd').val("");
	            		$('#id').focus();
	            	}
	            }
	       });
	   });
   });
</script>