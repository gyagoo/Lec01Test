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

<title>weather</title>
</head>
<body>
	<div class="container flex-shrink-0 p-3">
		<div>
			<%@ include file="nav.jsp" %>
		</div>
		<div>
			<section class="weather">
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
						<c:forEach var="weather" items="weather">
							<tr>
								<td>
									<%-- Date 타입으로 받았기 때문에 parseDate 필요 없음 --%>
									<fmt:formatDate value="${weather.date}" pattern="yyyy년 MM월 dd일" />
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
								<td><fmt:formatNumber value="${member.temperatures}" pattern="##.#" />℃</td>
								<td><fmt:formatNumber value="${member.precipitation}" pattern="##.#" />mm</td>
								<td>${weather.microDust }</td>
								<td><fmt:formatNumber value="${member.windSpeed}" pattern="##.#" />km/h</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</section>
		</div>
	
	</div>
</body>
</html>