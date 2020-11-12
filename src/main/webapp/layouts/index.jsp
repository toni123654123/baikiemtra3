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
					<td>${product.getName()}</td>
					<td>${product.getPrice()}</td>
					<td>${product.getTotal()}</td>
					<td>${product.getColor()}</td>
					<td>${product.getDesc()}</td>
					<td>${product.nameCategory()}</td>
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
