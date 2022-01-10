<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- bootstrap CDN link -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<!-- 선생님 코드 -->
  <link rel="stylesheet" href="style.css" type="text/css">
  
<title>weather</title>
</head>
<body>
	<div id="wrap">
		<div class="d-flex">
			
			 <nav>
			     <div class="logo d-flex justify-content-center mt-3">
			         <img class="logo-image mr-2" src="https://www.kma.go.kr/kma/resources/images/sub/sig2.png" > 
			         <span class="text-white logo-text">기상청</span>
			     </div>
			
			     <ul class="nav flex-column mt-4">
			         <li class="nav-item"><a href="/lec05/weather" class="nav-link main-link">날씨</a></li>
			         <li class="nav-item"><a href="/lec05/view" class="nav-link main-link">날씨입력</a></li>
			         <li class="nav-item"><a href="#" class="nav-link main-link">테마날씨</a></li>
			         <li class="nav-item"><a href="#" class="nav-link main-link">관측 기후</a></li>
			     </ul>
			 </nav>
			
			<section class="weather mt-3 ml-5">
				<h1>과거 날씨</h1>
				<table class="table text-center">
					<thead>
						<tr>
							<th>날짜</th>
							<th>날씨</th>
							<th>기온</th>
							<th>강수량</th>
							<th>미세먼지</th>
							<th>풍속</th>							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="weather" items="${weatherhistory}">
							<tr>
								<td>
									<%-- Date 타입으로 받았기 때문에 parseDate 필요 없음 --%>
									<fmt:formatDate value="${weather.date}" pattern="yyyy년 M월 d일" />
								</td>
								<td>
									<c:choose>
										<c:when test="${weather.weather eq '맑음' }">
											<img src="http://marondal.com/material/images/dulumary/web/jstl/sunny.jpg" alt="sunny" width="50">
										</c:when>
										<c:when test="${weather.weather eq '구름조금' }">
											<img src="http://marondal.com/material/images/dulumary/web/jstl/partlyCloudy.jpg" alt="gloomy" width="50">
										</c:when>
										<c:when test="${weather.weather eq '흐림' }">
											<img src="http://marondal.com/material/images/dulumary/web/jstl/cloudy.jpg" alt="cloudy" width="50">
										</c:when>
										<c:when test="${weather.weather eq '비' }">
											<img src="http://marondal.com/material/images/dulumary/web/jstl/rainy.jpg" alt="rainy" width="50">
										</c:when>
									</c:choose>
								</td>
								<td><fmt:formatNumber value="${weather.temperatures}" pattern="##.#" />℃</td>
								<td><fmt:formatNumber value="${weather.precipitation}" pattern="##.#" />mm</td>
								<td>${weather.microDust }</td>
								<td><fmt:formatNumber value="${weather.windSpeed}" pattern="##.#" />km/h</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</section>
	</div>		
	
	</div>
</body>
</html>