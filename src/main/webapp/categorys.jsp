<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="hello">
    Tên: <input name="ten"/>
    <button type="submit">Search</button>
</form>
<br/>
<button><a href="">Add Cate</a></button>
<%--   hiện thị dữ liệu jsp: table/ì..else/switch...case -> jstl <c:ten ham>--%>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Cate code</th>
        <th>Cate name</th>
        <th>Hanh dong</th>
    </tr>
    </thead>
    <tbody>
<%--        for each: c:
    ${} dùng cho biến gọi từ servlet sang
--%>
    <c:forEach items="${listsCate}" var="cate">
    <tr>
        <td></td>
        <td>${cate.categoryCode}</td>
        <td>${cate.categoryName}</td>
        <td></td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
