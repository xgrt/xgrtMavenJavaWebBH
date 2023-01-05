<%@ page import="java.util.List" %>
<%@ page import="com.xgrt.pojo.Brand" %>
<%@page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>主页</title>
</head>
<body>
<input type="button" value="新增" id="add"><br>
<hr>
<table border="1" cellspacing="0" width="100%">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${brands}" var="brand" varStatus="status">
        <td>${status.count}</td>
        <td>${brand.brandName}</td>
        <td>${brand.companyName}</td>
        <td>${brand.ordered}</td>
        <td>${brand.description}</td>
        <c:if test="${brand.status==1}">
            <td>启用</td>
        </c:if>
        <c:if test="${brand.status!=1}">
            <td>禁用</td>
        </c:if>
        <td>
            <a href="/TotalExample/selectById?id=${brand.id}">修改</a> &nbsp;
            <a href="/TotalExample/deleteServlet?id=${brand.id}">删除</a>
        </td>
        </tr>
    </c:forEach>
</table>


<script>
    document.getElementById("add").onclick = function () {
        location.href = "/TotalExample/addBrand.jsp";
    }
</script>
</body>
</html>
