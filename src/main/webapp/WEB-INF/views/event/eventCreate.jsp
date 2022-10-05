<%@page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>새글등록</title>
</head>
<body>
   <center>
      <h1>글 등록</h1>
      <a href="/logout">Log-out</a>
      <hr>
      <form action="/eventCreateAction" method="post" enctype="multipart/form-data">
         <table border="1" cellpadding="0" cellspacing="0">
            <tr>
               <td bgcolor="orange" width="70">제목</td>
               <td align="left"><input type="text" name="EVENTTITLE" /></td>
            </tr>
           
            <tr>
               <td bgcolor="orange">내용</td>
               <td align="left"><textarea name="EVENTCONTENT" cols="40" rows="10"></textarea></td>
            </tr>
            <tr>
               <td bgcolor="orange" width="70">업로드</td><td align="left">
               <input type="file" name="uploadFile"/></td>
            </tr>
            <tr>
               <td colspan="2" align="center"><input type="submit"
                  value=" 새글 등록 " /></td>
            </tr>
         </table>
      </form>
      <hr>
      <a href="/event">글 목록 가기</a>
   </center>
</body>
<script>
 $(document).ready(function() {
         // 새글 등록 버튼
         $(".eventCreate_button").click(function() {
            $("#eventCreate_button_form").attr("action", "/eventCreateAction");
            $("#eventCreate_button_form").submit();

         })
      })
</script>
</html>