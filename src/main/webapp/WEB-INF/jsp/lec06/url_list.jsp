<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- bootstrap CDN link -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


<title>Insert title here</title>
</head>
<body>
	<table class="table text-center">
		<thead>
			<tr>
				<th>NO.</th>
				<th>이름</th>
				<th>주소</th>
				<th></th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="url" items="${url_list}" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${url.name }</td>
					<td><a href="${url.url }">${url.url }</a></td>
					<td><button class="deleteBtn btn btn-danger form-control btn-sm" data-url-id="${url.id }">삭제</button></td> 
				</tr>
			</c:forEach>
		</tbody>
		
	</table>
	
	<script>
		$(document).ready(function() {
			$(".deleteBtn").on("click", function() {	// 버튼이 하나가 아니기 때문에 id 사용X
				let id = $(this).data("url-id");	// this는 이벤트를 위해 클릭된 버튼을 의미 *****, data- 속성 추가와 사용 *****
	
				$.ajax({
					type:"get",
					url:"/lec06/delete_url",
					data:{"id": id},
					success: function(data) {
						alert("삭제 성공");
						location.reload();	// 새로고침
					},
					error: function() {
						alert();
					}
				});
			});
	});
	</script>

	
	
</body>
</html>