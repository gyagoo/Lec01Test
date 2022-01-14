<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<title>add booking</title>
</head>
<body>
	<div class="container">
		<div>
			<label>이름</label>	<input type="text" class="form-control mb-3" id="nameInput" name="name">
		</div>
		<div>
			<label>예약날짜</label>	<input type="text" class="form-control mb-3" id="dateInput" name="date">
		</div>
		<div>
			<label>숙박일수</label>	<input type="text" class="form-control mb-3" id="dayInput" name="day">
		</div>
		<div>
			<label>숙박인원</label>	<input type="text" class="form-control mb-3" id="headcountInput" name="headcount">
		</div>
		<div>
			<label>전화번호</label>	<input type="text" class="form-control mb-3" id="phoneNumberInput" name="phoneNumber">
		</div>
		<button class="btn btn-warning text-dark form-control" id="bookingBtn" value="예약하기">예약하기</button>
	</div>
	
	<script>
		$(document).ready(function() {
			
			$("#bookingBtn").on("click", function() {
				let name = $("#nameInput").val();
				let date = $("#dateInput").val();	// date
				let day	= $("#dayInput").val();
				let headcount = $("#headcountInput").val();
				let phoneNumber = $("#phoneNumberInput").val();
				
				alert(name+" "+date+" "+day+" "+headcount+" "+phoneNumber);
				
				
				// validation
				if (name == "") {
					alert("이름을 입력하세요");
					return;
				}
				if (date == "") {
					alert("날짜를 입력하세요");
					return;
				}
				if (day == "") {
					alert("숙박일수를 입력하세요");
					return;
				}
				if (headcount == "") {
					alert("숙박인원을 입력하세요");
					return;
				}
				if (phoneNumber == "") {
					alert("전화번호를 입력하세요");
					return;
				}
				$.ajax({
					type:"post",
					url:"/lec06/go_booking",
					data:{"name":name, "date":date, "day":day, "headcount":headcount, "phoneNumber":phoneNumber},
					success: function(data) {
						if (data == "success")	 {
							alert("예약되셨습니다");
							location.href="/lec06/booking_list";
						} else {
							alert("예약에 실패하셨습니다");
						}
					},
					error: function() {
						alert("error");
					}
				});
			});
			
		});
	
	</script>
</body>
</html>