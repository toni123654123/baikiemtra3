<%--
  Created by IntelliJ IDEA.
  User: toanv
  Date: 01/07/2020
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Add</title>
</head>
<body>

<form method="post">
<center>
	<h2>ADD PRODUCT</h2>
	<a href="/">BACK</a>
	<table>
		<tbody>
			<tr>
				<td>Tên sản phẩm</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Giá</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td>Số lượng</td>
				<td><input type="text" name="total"></td>
			</tr>
			<tr>
				<td>Màu sắc</td>
				<td><input type="text" name="color"></td>
			</tr>
			<tr>
				<td>Mô tả</td>
				<td><input type="text" name="desc"></td>
			</tr>
			<tr>
				<td>Danh mục</td>
				<td>
					<select type="text" name="category">
					<c:forEach items='${requestScope["lists"]}' var="category" >
						<option value="${category.id}">${category.name}</option>
					</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="ADD"></td>
			</tr>
		</tbody>
	</table>
</center>
</form>
</body>
</html>
