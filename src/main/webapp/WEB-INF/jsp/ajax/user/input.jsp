<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.6.3.min.js"
  integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
  crossorigin="anonymous"></script>
</head>
<body>

	<!--  <form method="get" action="/ajax/user/add" id="saveForm"> -->
		<label>이름</label> <input type="text" name="name" id="nameInput">
		<label>생년월일</label> <input type="text" name="yyyymmdd" id="yyyymmddInput">
		<label>이메일</label> <input type="text" name="email" id="emailInput">
		
		<button type="button" id="saveBtn">저장</button>
	<!--  </form> -->

	<script>
		$(document).ready(function() {
			
			$("#saveBtn").on("click", function() {
				let name = $("#nameInput").val();
				let yyyymmdd = $("#yyyymmddInput").val();
				let email = $("#emailInput").val();
				
				if(name == "") {
					alert("이름을 입력하세요");
					return;
				}
				if(yyyymmdd == "") {
					alert("생년월일을 입력하세요");
					return;
				}
				if(email == "") {
					alert("이메일을 입력하세요");
					return;
				}
				
				
				$.ajax({
					// request 옵션들: ajax가 이 내용들을 서버에 요청
					type:"get"
					, url:"/ajax/user/add"
					, data:{"name":name, "yyyymmdd":yyyymmdd, "email":email}
					// response 옵션
					, success:function(data) {  // request 옵션 data 아니고 response에 담겨져 오는 데이터를 의미. 다른 변수 이름 해도 무방.
												// 문자열이 아닌 json 형태로 {"result":"success"} 이렇게 이미 객체로 변환해주기 때문에 data.result 를 부르면 success가 나온다.
												// 서버와 ajax 사이는 데이터가 바로 전달이 안되고 그저 문자열 형태로만 전달이 된다. 따라서 변수 전달은 안됨. ajax의 jquery가 문자열을 json으로 변환해주는 것.
						if(data.result == "success") {
							// 리스트 페이지로 이동
							location.href="/ajax/user/list";
						} else {
							alert("저장 실패"); // count가 리턴 됐지만 1이 아닌 경우
						}
					}
					, error:function() {  // 아예 요청 자체가 안된 경우
						alert("저장 에러");
					}
				});
				
				
			});
			
			
			/*
			$("#saveForm").on("submit", function() {
				let name = $("#nameInput").val();
				if(name == "") {
					alert("이름을 입력하세요");
					return false;
				}
			})
			*/
		});
	</script>
</body>
</html>