<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- c태그 사용 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">

<style>
#wrapper {
	width: 1000px;
	margin: auto;
	margin-top: 30px;
	border-radius : 10px ;
}
#title{
text-align:center;
align-content: center;
}
td:hover{
text-decoration: underline;

}

h1{
text-align:center;
}
#button{
text-align:center;
}
</style>
</head>
<body>

<form id="itemselect" method="post">
	<!-- 게시판 부트스트랩 -->
	<div class="wrapper">
		<div id="wrapper">
		<h1>아이템</h1>
			<table class="table" >
				<thead class="table-dark">
					<tr >
						<th id="title" width="100" scope="col">번호</th>
						<th id="title"   scope="col">제목/내용</th>
						<th id="title" width="100"scope="col">아이디</th>
						<th id="title" width="100"scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="list">
						<tr >
							<td id="title" style="text-decoration: none;"><c:out  value="${list.reviewnum}" /></td>
							<td style="text-decoration: none;"><c:out   value="${list.reviewtitle}" /><br> <br>
							<c:out value="${list.reviewcontent}" /></td>
							<td  ><c:out   value="${list.id}" /></td>
							<td><a href="/reviewout?num=${list.reviewnum}"><button type="button">삭제</button></a> </td>
						</tr>
					</c:forEach>
					
					
				</tbody>
			</table>
			</div>
		</div>
		</form>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
		
</body>
</html>