<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- bootstrap CDN link -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	
		<h1>판매자 추가</h1>
		
		<form method="post" action="/lec04/test01/add_seller">
			<div class="nickname">
				<div>
					<label>닉네임</label>
				</div>
				<div>
					<input type="text" class="form-control" name="nickname">
				</div>	
			</div>
			
			<div class="url">
				<div>
					<label>프로필 사진 url</label>
				</div>
				<div>
					<input type="text" class="form-control" name="profileImageUrl">
				</div>		
			</div>
			
			<div class="temperature">
				<div>
					<label>온도</label>
				</div>
				<div>
					<input type="text" class="form-control" name="temperature">
				</div>
			</div>
		
			<input type="submit" class="btn btn-primary text-white" value="추가">
		</form>
	</div>
</body>
</html>