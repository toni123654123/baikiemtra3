<%--
  Created by IntelliJ IDEA.
  User: toanv
  Date: 01/07/2020
  Time: 08:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<style>
    table {
        background: #fff;
    }
    thead {
        background: #d9d9d9;
    }
    tr {
        padding: 6px;
    }
    td {
        padding: 6px;
    }

    tr + tr {
        border-top: 1px solid #d9d9d9;
    }
</style>
<head>
    <title>Product manager</title>

</head>
<body>
<center>
    <a href="/add">Add product</a>
    <form method="post">
        <input type="text" name="search" value="" />
        <input type="submit" value="Search" />
    </form>
    <table>
        <thead>
        <tr>
            <td>ID</td>
            <td>Tên sản phẩm</td>
            <td>Giá bán</td>
            <td>Số lượng</td>
            <td>Màu sắc</td>
            <td>Mô tả</td>
            <td>Danh mục</td>
            <td>ACTION</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items='${requestScope["lists"]}' var="product" >
            <tr>
                <td>${product.getId()}</td>
                <td>${product.getName()}</td>
                <td>${product.getPrice()}</td>
                <td>${product.getTotal()}</td>
                <td>${product.getColor()}</td>
                <td>${product.getDesc()}</td>
                <td>${product.getCategory()}</td>
                <td>
                    <a href="/edit?id=${product.getId()}">Edit</a>
                    <a href="/delete?id=${product.getId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</center>
</body>
</html>
