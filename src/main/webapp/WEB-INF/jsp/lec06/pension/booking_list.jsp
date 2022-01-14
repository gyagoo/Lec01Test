<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<title>reservation list</title>
</head>
<body>
	<div class="wrap">
		<div class="container">
				<h1 class="text-center"> 예약 목록 보기 </h1>
			<div>
				<table class="table text-center">
					<thead>
						<tr>
							<th>이름</th>
							<th>예약날짜</th>
							<th>숙박일수</th>
							<th>숙박인원</th>
							<th>전화번호</th>
							<th>예약상태</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						
						<c:forEach var="booking" items="${bookinglist }">
							<tr>
								<td>${booking.name }</td>
								<td>
									<fmt:formatDate value="${booking.date }" pattern="yyyy년 MM월 dd일" />
								</td>
								<td>${booking.day }</td>
								<td>${booking.headcount }</td>
								<td>${booking.phoneNumber }</td>
								<c:choose>
									<c:when test="${booking.state eq '대기중'}">
										<td class="text-primary">${booking.state }</td>
									</c:when>
									<c:when test="${booking.state eq '확정' }">
										<td class="text-success">${booking.state }</td>
									</c:when>
								</c:choose>
								<td><button class="deleteBtn btn btn-danger form-control btn-sm" data-booking-id="${booking.id }">삭제</button></td>
							</tr>
						</c:forEach>
						
						
						<script>
							$(document).ready(function() {
								$(".deleteBtn").on("click", function() {
									let id = $(this).data("booking-id");
									
									$.ajax({
										type:"get",
										url:"/lec06/delete_booking",
										data:{"id":id},
										success: function(data) {
											alert("예약이 취소되셨습니다.}");
											location.reload();	// 새로고침
										},
										
										error: function() {
											alert("error");
										}
									});
								});
							});
						
						</script>
					</tbody>
				</table>
			
			</div>
			
		</div>
	</div>
	

</body>
</html>