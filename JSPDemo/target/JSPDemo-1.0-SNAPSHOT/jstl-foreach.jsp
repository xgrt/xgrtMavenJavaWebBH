<%--
  Created by IntelliJ IDEA.
  User: xgrt
  Date: 2022/12/3
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="button" value="新增"><br>
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
        <tr align="center">
            <%--<td>${brand.id}</td><!--写属性名称-->--%>
            <td>${status.count}</td><!--index是从零开始，count是从1开始-->
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <td>
                <c:if test="${brand.status==0}">禁用</c:if>
                <c:if test="${brand.status==1}">启用</c:if>
            </td>
            <td><a href="#">修改</a>&nbsp;<a href="#">删除</a></td>
        </tr>
    </c:forEach>
</table>
<hr>
<c:forEach begin="1" end="10" step="1" var="i">
    <a href="#">${i}</a>
</c:forEach>
</body>
</html>
