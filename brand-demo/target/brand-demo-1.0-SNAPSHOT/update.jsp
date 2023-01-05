<%--
  Created by IntelliJ IDEA.
  User: xgrt
  Date: 2022/12/1
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>修改</title>
</head>
<body>
<h3>修改品牌</h3>
<form action="/brand_demo/updateServlet" method="post">
    <%--隐藏域--%>
    <input type="hidden" name="id" value="${brand.id}">
    品牌名称：<input name="brandName" value="${brand.brandName}"><br>
    企业名称：<input name="companyName" value="${brand.companyName}"><br>
    排序：<input name="ordered" value="${brand.ordered}"><br>
    描述信息：<textarea rows="5" cols="20" name="description">${brand.description}</textarea><br>
    状态：
    <c:if test="${brand.status==0}">
        <input type="radio" name="status" value="0" checked>禁用
        <input type="radio" name="status" value="1">启用
    </c:if>
    <c:if test="${brand.status==1}">
        <input type="radio" name="status" value="0">禁用
        <input type="radio" name="status" value="1" checked>启用
    </c:if>
    <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
