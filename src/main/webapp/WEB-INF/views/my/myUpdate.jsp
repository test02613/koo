<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"
   integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
   crossorigin="anonymous"></script>
</head>
<body>
<form id="update" method="post">
<table>
 				<tr>
					<td >이름</td>
					<td align="left"><input type="text" name="name" value="${member.name}"/></td>
				</tr>
 				<tr>
					<td >비번</td>
					<td align="left"><input type="password" name="pw" value="${member.pw}"/></td>
				</tr>
 				<tr>
					<td >모바일</td>
					<td align="left"><input type="text" name="mobile" value="${member.mobile}"/></td>
				</tr>
				
</table>
				 <input type="button" class="update_button" value="변경">
				
</form>
<script>
$(document).ready(function() {
        
         $(".update_button").click(function() {
            $("#update").attr("action", "/myupdateAction");
            $("#update").submit();

         })
      })
</script>
</body>
</html>