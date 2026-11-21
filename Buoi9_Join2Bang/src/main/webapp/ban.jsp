<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 21/11/26
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<select>
    <c:forEach items="${listMQH}" var="mqh">
        <option>${mqh.ten}</option>
    </c:forEach>
</select>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Ma</th>
        <th>Ten</th>
        <th>Gioi tinh</th>
        <th>So thich</th>
        <th>Ma MQH</th>
        <th>Ten MQH</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listBan}" var="b" varStatus="i¬">
        <tr>
            <td>${i.index}</td>
            <td>${b.ma}</td>
            <td>${b.ten}</td>
            <td>${b.gioiTinh}</td>
            <td>${b.soThich}</td>
            <td>${b.ban.ma}</td>
            <td>${b.ban.ten}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
