<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 5/11/26
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="POST" action="/ket-qua">
    MSSV:<input type="text" name="mssv1"> <br>
    Ten: <input type="text" name="ten1"> <br>
    Tuoi: <input type="number" name="tuoi"><br>
    Gioi tinh: <input type="radio" name="gioiTinh" value="male"> Nam
    <input type="radio" name="gioiTinh" value="female"> Nu <br>
    Chuyen nganh:
    <select name="chuyenNganh">
        <option value="ptpm">phat trien phan mem</option>
        <option value="udpm">Ung dung phan mem</option>
        <option value="tkdh">thiet ke do hoa</option>
    </select> <br>
    <button type="submit">Dang ky</button>
</form>
</body>
</html>
