<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- bootstrap CDN link -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


<title>add url</title>
</head>
<body>
	<div class="container">
		<div>
			<h1>즐겨찾기 추가하기</h1>
			<div class="name">
				<label>제목</label> 
				<input type="text" id="nameInput" class="form-control"> <br>
			</div>
			
			<div class="url">
				<label>주소</label>
				<div class="d-flex">
					<input type="text" id="urlInput" class="form-control mr-3"> 
					<button type="button" value="중복확인" id="duplicateBtn" class="form-control btn btn-primary col-2 ">중복확인</button>	
				</div>
				<label id="duplicateMsg" class="text-danger d-none">중복된 url입니다.</label>
				<label id="availableMsg"></label>
			</div>

			<div class="d-flex mt-3">
				<button type="button" value="추가" id="addUrl" class="form-control btn btn-success">추가</button>
			</div>
		</div>
	</div>
	
	
	
	<script>
		$(document).ready(function() {
			
			var isDuplicateUrl = true;
			
			
			
			$("#addUrl").on("click",function() {
				let name = $("#nameInput").val();
				let url = $("#urlInput").val();
				
				// validation
				if (name == "") {
					alert("제목을 입력하세요");
					return;
				}
				if (url == "") {
					alert("url 주소를 입력하세요");
					return;
				}
				if (!(url.startsWith("http://") || url.startsWith("https://"))) {
					alert("올바르지 않은 주소입니다.")
				}
				
				$.ajax({
					type:"post",
					url:"/lec06/add_url",	// 앞에 슬래쉬가 빠지면 상대주소가 됨
					data:{"name":name, "url":url},	// 서버에서 요청한 형태:내가 만든 형태
					
					success : function(data) {	// reponse가 돌아왔을 때 함수 실행
						if(data == "success") {
							alert("입력 성공");
							location.href = "/lec06/url_list";	// 성공시 url_list 페이지로 이동
						} else {
							alert("입력 실패");
						}
					},
					
					error : function() {
						alert("에러발생");
					}
				});
			
			});
			
			
			
			
			// 중복확인
			$("#duplicateBtn").on("click", function() {
				let url = $("#urlInput").val();
				// validation
				if(url == "") {
					alert("url 주소를 입력해주세요.");
					return;
				}
				
				$.ajax({
					type:"post",
					url:"/lec06/duplicate_url",
					data:{"url":url},
					
					success: function(data) {
						if(data.isDuplicate == "true") {
							alert("중복된 url 입니다.");
							$("#duplicateMsg").removeClass("d-none");
							$("#availableMsg").addClass("d-none");
							isDuplicateUrl = true;
						} else {
							alert("저장 가능한 url 입니다.");
							$("#duplicateMsg").addClass("d-none");
							$("#availableMsg").removeClass("d-none");
							isDuplicateUrl = false;
						}
					},
					
					error: function() {
						alert("error")
					}
				});
		
			});
			
			
		});
	</script>
</body>
</html>