<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/3
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>登录</title>
    <link href="css/login.css" type="text/css" rel="stylesheet">
</head>


<%
    String name="";

    HttpServletRequest request1=(HttpServletRequest)request;
    Cookie[] cookies=request1.getCookies();
    if(cookies!=null){
        for(int i=0;i<cookies.length;i++){
            if("userName".equals(cookies[i].getName())){
                name=cookies[i].getValue();
                break;
            }
        }
    }

%>

<body>
<div class="div_top">OA日常办公管理系统</div>
<div class="login">
    <div class="message">用户登录</div>
    <div id="darkbannerwrap"></div>

    <form method="post" action="LoginServlet">
        <input name="action" value="login" type="hidden">
        <input name="username" placeholder="用户名" required="" value="<%=name%>" type="text" id="user">
        <hr class="hr15">
        <input name="password" placeholder="密码" required="" type="password" id="pass">
        <hr class="hr15">
        <input value="登录" style="width:100%;" type="submit" id="login_btn">
        <hr class="hr20">
        <a onClick="alert('请联系管理员')">忘记密码</a>

        <input type="checkbox" name="rem" value="1"/>记住账号

    </form>


</div>

<div class="copyright">版权所有@<span style="color:#f77118">2017 </span>杭州天夏科技股份集团有限公司</div>
<script type="text/javascript" src="js/jquery.js"></script>
<script >
    $(function(){
        $("#login_btn").click(function(){

            var selectuser = $("#user").val();
            var pword = $("#pass").val();

            if (selectuser == "" || selectuser.length <= 1) {
                alert("用户名不能为空");
                $("#user").focus();
                return false;
            }
            if (pword == "" || pword.length < 1) {
                alert("密码不能为空");
                $("#pass").focus();
                return false;
            }
            getUserDep(selectuser,pword);


        });

        function getUserDep(v1,v2){
            $.ajax({
                type: "post",
                url: "LoginServlet",
                data:{adid:v1,mima:v2},
                success: function(message){
                    if(message=="1"){
                        window.location.href='index.html';
                    }
                    else{
                        alter("密码错误");
                    }
                }

            });
        }
    });

</script>
</body>
</html>