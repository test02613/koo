<%@page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- c�±� ��� -->
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.js"
   integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
   crossorigin="anonymous"></script>
<title>���۵��</title>
</head>
<body>

	<center>
	
		<a href="/logout">Log-out</a>
		<hr>
		<form id="eventCreate_form" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
				<td>
				<input type="hidden" name = "ordernum" value="${order}">
				<input type="hidden" name = "itemnum" value="${item}">
				</td>
				</tr>
				
				<tr>
					<td bgcolor="orange" width="70">����</td>
					<td align="left"><input type="text" name="reviewtitle" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">����</td>
					<td align="left"><textarea name="reviewcontent" cols="40" rows="10"></textarea></td>
				
					
				</tr>
				
				
				
					
				
				
			</table>
			
			 <input type="button" class="eventCreate_button" value="����ϱ�">
			 
			
		</form>
		<hr>
		<a href="/event">�� ��� ����</a>
	</center>
<script>
 $(document).ready(function() {
         // ���� ��� ��ư
         $(".eventCreate_button").click(function() {
            $("#eventCreate_form").attr("action", "/reviewCreateAction");
            $("#eventCreate_form").submit();

         })
      })
/*  $(document).ready(function() {
         // ���� ��� ��ư
         $(".eventUpdate_button").click(function() {
            $("#eventCreate_form").attr("action", '${path}/eventUpdateAction?num=${detail.eventnum}');
            $("#eventCreate_form").submit();

         })
      }) */
</script>
</body>
</html>