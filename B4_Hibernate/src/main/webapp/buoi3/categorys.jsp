<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="">
    Tên: <input name="ten"/>
    <button type="submit">Search</button>
</form>
<br/>
<button><a href="/category/view-add">Add Cate</a></button>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Ma</th>
        <th>Ten</th>
        <th>Hanh dong</th>
    </tr>
    </thead>
    <tbody>
    <%--   for(SinhVien sv : lists)
    items -> dung de chua mang
    var -> doi tuong
    varStatus -> for(int i = 0) -> vi tri cua mang
    --%>
    <c:forEach items="${lists1}" var="cate" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${cate.categoryCode}</td>
            <td>${cate.categoryName}</td>
            <td>
                    <%--                int a = 5--%>
                <a href="/category/delete?a=${cate.id}">Delete</a>
                <a href="/category/view-update?id=${cate.id}">View Update</a>
                <a href="/category/detail?b=${cate.id}">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
