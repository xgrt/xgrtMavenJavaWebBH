<%@page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link href="css/login.css" rel="stylesheet">
</head>

<body>
<div id="loginDiv" style="height: 350px">
    <form action="/brand_demo/loginServlet" id="form">
        <h1 id="loginMsg">登录</h1>
        <div id="errorMsg">${request_msg}${login_msg}</div>
        <p>用户名:<input id="username" name="username" type="text" value="${cookie.username.value}"></p>

        <p>密码:<input id="password" name="password" type="password" value="${cookie.password.value}"></p>
        <p>记住我&nbsp;<input id="remember" name="remember" type="checkbox" value="1"></p>
        <div id="subDiv">
            <input type="submit" class="button" value="登录">
            <input type="reset" class="button" value="清空">&nbsp;&nbsp;&nbsp;<br>
            <a href="register.jsp">没有账号？</a>
        </div>
    </form>
</div>

</body>
</html>
