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
<button><a href="/category/view-add">Add Cate</a></button>
<%--   hiện thị dữ liệu jsp: table/ì..else/switch...case -> jstl <c:ten ham>--%>
<table border="1" cellspacing="1" cellpadding="10">
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
<%--luu y--%>
    <c:forEach items="${listsCate}" var="cate">
    <tr>
        <td>${i.index+1}</td>
        <td>${cate.categoryCode}</td>
        <td>${cate.categoryName}</td>
        <td>
            <%-- cach truyen gia tri tren duowng dan
            1. neu chi truyen 1 gia tri thi dung dau "?"
            2.neu truyen nhieu hown 1 duowng dan: gia tri thu 2 tro di se la dau "&"
            --%>
            <a href="/category/delete?a=${cate.id}"> Delete</a>
            <a href="/category/detail?a=${cate.id}">Detail</a>
            <a href="/category/view-update?a=${cate.id}">Update</a>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
