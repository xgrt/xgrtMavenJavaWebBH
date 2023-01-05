<%--
  Created by IntelliJ IDEA.
  User: xgrt
  Date: 2022/12/6
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link href="css/register.css" rel="stylesheet">
</head>
<body>

<div class="form-div">
    <div class="reg-content">
        <h1>欢迎注册</h1>
        <span>已有账号？</span> <a href="login.jsp">登录</a>
    </div>
    <form id="reg-form" action="/BrandExample/registerServlet" method="post">

        <table>

            <tr>
                <td>用户名</td>
                <td class="inputs">
                    <input name="username" type="text" id="username">
                    <br>
                    <span id="username_err" class="err_msg">${request_msg}</span>
                </td>

            </tr>

            <tr>
                <td>密码</td>
                <td class="inputs">
                    <input name="password" type="password" id="password">
                    <br>
                    <span id="password_err" class="err_msg" style="display: none">密码格式有误</span>
                </td>
            </tr>


            <tr>
                <td>验证码</td>
                <td class="inputs">
                    <input name="checkCode" type="text" id="checkCode">
                    <img id="checkCodeImg" src="/BrandExample/checkCodeServlet">
                    <a href="#" id="changeImg">看不清？</a>
                    <br>
                    <span id="err_msg" class="err_msg">${checkCode_msg}</span>
                </td>
            </tr>

        </table>

        <div class="buttons">
            <input value="注 册" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>
</div>

<script>
    document.getElementById("changeImg").onclick = change_img;
    document.getElementById("checkCodeImg").onclick=change_img;
    function change_img() {
        //重复的路径会被浏览器保存，导致图片不会改变
        document.getElementById("checkCodeImg").src = "/BrandExample/checkCodeServlet?"
            + new Date().getMilliseconds();
    }
</script>
</body>
</html>
