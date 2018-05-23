<%--
  Created by IntelliJ IDEA.
  User: xiaot
  Date: 2018/5/15
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
<h style="align-content: center">${currentTime}</h>
<br>
<table>
    <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>年龄</th>
    </tr>
<c:forEach items="${list}" var="item">
    <tr>
        <td>${item.id}</td>
        <td>${item.name}</td>
        <td>${item.age}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
