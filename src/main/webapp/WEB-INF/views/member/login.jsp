<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<meta charset="UTF-8" />
<!-- <meta name="google-signin-client_id" content="840345488051-t7d9q5tg8he8kt3om4dmlovpjom64m3q.apps.googleusercontent.com"> -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css"> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<!-- <script src="https://apis.google.com/js/platform.js" async defer></script> -->
<!-- <script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script> -->
<!-- <script src ="//developers.kakao.com/sdk/js/kakao.min.js"></script> -->

<style>
/* 로그인 페이지 전체 영역 css */
#loginform {
   width: 500px;
   margin: 0 auto;
   margin-top: 50px;
   text-align: center;
   margin-bottom: 100px
}

/* 로그인 타이틀 */
.contents {
   height : 100px;
   color : #24292F;
   font-size : 40px;
   margin-top : 20px;
}

/* 로그인 구성요소 : a 태그들 */
.logintable>#frm>a {
   float: center;
   margin-top : 50px;
   padding : 10px;
}

/* 로그인 구성요소 : 입력란 */
.logintable>#frm>.form-control {
   width: 100%;
   height: 50px;
   border: 1px solid #e0e0e0;
   border-radius : 10px;
   margin-bottom: 20px;
}

/* 로그인 구성요소 : 로그인 버튼 */
#login {
   width: 100%;
   height: 50px;
   display: block;
   border: none;
   border-radius: 10px;
   margin-top: 20px;
   margin-bottom: 40px;
   font-size: 20px;
   color : white;
   background-color : #24292F;
}

/* 적용 안 되어있는 css들 주석처리해둠 */
/* h1 {
   text-align: center;
   padding: 50px 0;
   font-weight: normal;
   font-size: 2em;
   letter-spacing: 10px;
} */

/* .btn-social-login {
   outline: 0;
   border: 1px solid transparent;
   padding: .5rem !important;
   border-radius: 10%;
   color: #fff;
} */

/* .text-dark { color: #343a40!important; } */
</style>

   <div id="loginform">
      <h3 class="contents">로그인</h3>
      <div class="logintable">
         <form action="loginAction" method="POST" id="frm">
            <input type="text" class="form-control" name="id"
               id="memberId" placeholder=" 아이디">
            <input type="password" class="form-control" name="pw"
               id="memberPw" placeholder=" 비밀번호">
            
            <button type="submit" id="login">로그인</button>
            
            <a href="/findId">아이디 찾기</a>
            <a href="/findPw">비밀번호 변경</a>
   
         </form>
         <br> <!-- css로 조정하기 전에 갭 살짝 줌, 나중엔 빼버리기 -->
         <p>
         아직 회원이 아니신가요? <a href="join">회원가입하기 </a>
         </p>         
      </div>
   </div>

<script type="text/javascript">
if('${message}' != "") {
   alert('${message}');
}


//공란 확인
 $(document).ready(function() {
   
   $("#login").unbind("click").click(function(e) {
      e.preventDefault();
      fn_login();
   });

   function fn_login() {
      if($("#memberId").val()==""){
         alert("아이디를 입력해주세요");
         $("#memberId").focus();
      } else if($("#memberPw").val()==""){
         alert("비밀번호를 입력해주세요");
         $("#memberPw").focus();
      } else {
         $("#frm").submit();
      }
   }
}); 
var googleUser = {};
var startApp = function() {
  gapi.load('auth2', function(){
    auth2 = gapi.auth2.init({
      client_id: '840345488051-t7d9q5tg8he8kt3om4dmlovpjom64m3q.apps.googleusercontent.com',
      cookiepolicy: 'single_host_origin',
    });
    attachSignin(document.getElementById('customBtn'));
  });
};

function attachSignin(element) {
    console.log(element.id);
    auth2.attachClickHandler(element, {},
        function(googleUser) {
          onSignIn(googleUser);
        });
  }

function onSignIn(googleUser) {
    var profile = googleUser.getBasicProfile();
    var id_token = googleUser.getAuthResponse().id_token;
   var data={};
   data["ID"] = profile.getId();
   data["Name"] = profile.getName();
   data["Image URL"] = profile.getImageUrl();
   data["Email"] = profile.getEmail();
   data["ID Token"] = id_token;
    $.ajax({
       type : "POST",
      url : "${pageContext.request.contextPath}/socialLoginAction.do",
      data : JSON.stringify(data),
      dataType : "json",   
      contentType:"application/json;charset=UTF-8",
       async: false,
      success : function(data, status, xhr) {
         console.log(data);
         location.href=data.URL;
      },
      error : function(jqXHR, textStatus, errorThrown) {
         alert("에러가 발생했습니다.");
      }
    });
};
startApp();

var naverLogin = new naver.LoginWithNaverId({
   clientId : "N7cehmsKQVMvrJ4lCsgv",
   callbackUrl : "http://localhost:8080/stu/loginCallback.do",
   isPopup : true,
   loginButton : {
      color : "green",
      type : 1,
      height :65
   }
});
naverLogin.init();

Kakao.init('9822692fe88226084f38bfae8387055b');

function loginWithKakao(){
    
    Kakao.Auth.cleanup();
    Kakao.Auth.login({
        persistAccessToken: true,
        persistRefreshToken: true,
        success: function(object) {
           Kakao.API.request({
               url: '/v2/user/me',
               success: function(res) {
                console.log(res);
                
                var userID = res.id;
                var userEmail = res.kakao_account.email;
                var userNickName = res.properties.nickname;
                var userbirthday = res.kakao_account.birthday;
                var data={};
               data["ID"] = userID;
               data["Name"] = userNickName;
               data["Email"] = userEmail;
               data["Birthday"] = userbirthday;
               
                $.ajax({
                   type : "POST",
                  url : "${pageContext.request.contextPath}/socialLoginAction.do",
                  data : JSON.stringify(data),
                  dataType : "json",   
                  contentType:"application/json;charset=UTF-8",
                   async: false,
                  success : function(data, status, xhr) {
                     console.log(data);
                     location.href=data.URL;
                  },
                  error : function(jqXHR, textStatus, errorThrown) {
                     alert("에러가 발생했습니다.");
                  }
                });
               },
               fail: function(error) {
                alert(JSON.stringify(error));
               }
              });
        },
            fail: function(err) {
             alert(JSON.stringify(err));
        }
    });
}
</script>