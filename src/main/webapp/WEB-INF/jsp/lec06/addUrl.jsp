<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- bootstrap CDN link -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <!-- jQuery 스크립트 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<title>add url</title>
</head>
<body>
	<h1> 즐겨찾기 추가하기</h1>
	<label>제목</label> <input type="text" id="nameInput"> <br>
	<label>주소</label> <input type="text" id="urlInput"> <br>
	<button type="submit" value="추가" id="submitBtn">추가</button>
	
	<script>
		$(document).ready(function() {
			
			$("#submitBtn").on("click".function() {
				let name = $("#nameInput").val();
				let url = $("#urlInput").val();
				
				// validation
				if (name == "") {
					alert("제목을 입력하세요");
					return false;
				}
				if (url == "") {
					alert("url 주소를 입력하세요");
					return false;
				}
				
				$.ajax({
					type:"post",
					url:"/lec06/add_url",
					data:{"name":name, "url":url},
					
					succes : function(data) {
						if(data == "success") {
							alert(data);
						} else {
							alert("입력 실패");
						}
					},
					
					error : function() {
						alert("에러발생");
					}
				});
				
				return false;
			});
		});
	</script>
</body>
</html>