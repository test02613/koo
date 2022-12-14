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
	border-radius: 10px;
}

#title {
	text-align: center;
	align-content: center;
}

td:hover {
	text-decoration: underline;
}

h1 {
	text-align: center;
}

#button {
	text-align: center;
}
</style>
</head>
<body>


	<!-- 게시판 부트스트랩 -->
	<div class="wrapper">
		<div id="wrapper">
			<h1>이벤트</h1>
			<table class="table">
				<colgroup>
					<col width="20" />
					<col width="*" />
					<col width="10%" />
					<col width="6%" />
					<col width="6%" />
				</colgroup>
				<thead class="table-dark">
					<tr>
						<th id="title" width="100" scope="col">주문번호</th>
						<th id="title" scope="col">제목</th>
						<th id="title" width="100" scope="col">작성일</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${review}" var="review">

						<tr>
							<td id="title" style="text-decoration: none;"><c:out
									value="${review.ordernum}" /> <br> <br>내용</td>
							<td onClick="location.href='/itemDetail?num=${review.itemnum}'"
								style="cursor: pointer;"><c:out
									value="${review.reviewtitle}" /> <br> <br>
							<c:out value="${review.reviewcontent}" /></td>
							<td style="text-decoration: none;"><c:out
									value="${review.reviewdate}" /></td>
							<td><a href="/reviewUpdate?num=${review.reviewnum}"><button
										type="button" class="review">수정</button></a></td>
							<td><a href="/myreviewout?num=${review.reviewnum}"><button
										type="button" class="review">삭제</button></a></td>
						</tr>

					</c:forEach>


				</tbody>
			</table>
		</div>

	</div>

	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
</body>
</html>