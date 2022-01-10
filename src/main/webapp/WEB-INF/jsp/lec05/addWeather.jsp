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

<title>add weather page</title>
</head>
<body>
	<div id="wrap">
		<div class="container d-flex">
			<%@ include file="sidebar.jsp" %>
		
			<section>
				<div class="add_page_title"><h1>날씨 입력</h1></div>
				
				<div>
					<form method="post" action="/lec05/add_weather">
						<div class="row d-flex justify-content-around">
							<div class="date">
								<label>날짜</label> <input type="text" name="date">
							</div>
							<div class="weather">
								<label>날씨</label> 
								<select name="weather">
									<option value="sunny" selected>맑음</option>
									<option value="gloomy">구름조금</option>
									<option value="cloudy">흐림</option>
									<option value="rainy">비</option>
								</select>
							</div>
							<div class="microDust">
								<label>미세먼지</label>
								<select>
									<option value="good" selected>좋음</option>
									<option value="usual">보통</option>
									<option value="bad">나쁨</option>
									<option value="worst">최악</option>
								</select>
							</div>				
						</div>
	
						<div class="row d-flex justify-content-around">
							<div class="temperatures input-group mb-3">
								<label>기온</label>
							  	<input type="text" class="form-control">
							  	<div class="input-group-append">
							    	<button class="btn btn-secondary text-white" type="button">℃</button>
							  	</div>
							</div>	
							
							<div class="precipitation input-group mb-3">
								<label>강수량</label>
							  	<input type="text" class="form-control">
							  	<div class="input-group-append">
							    	<button class="btn btn-secondary text-white" type="button">mm</button>
							  	</div>
							</div>	
							
							<div class="windSpeed input-group mb-3">
								<label>풍속</label>
							  	<input type="text" class="form-control">
							  	<div class="input-group-append">
							    	<button class="btn btn-secondary text-white" type="button">km/h</button>
							  	</div>
							</div>	
						</div>
						<div class="d-flex justify-content-end">
							<button class="btn btn-success text-white" type="submit" value="저장">저장</button>
						</div>
					</form>			
				</div>
			</section>
			
		</div>
	</div>
</body>
</html>