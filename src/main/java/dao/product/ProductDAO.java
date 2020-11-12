package dao.product;


import model.Product;
import service.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProduct {

	@Override
	public Product findById(String id) {
		Connection connection = Database.CreateConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE id = ?");
			statement.setString(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				Product product = new Product(resultSet);
				return product;
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(Product product) {
		Connection connection = Database.CreateConnection();
		String sql_insert = "INSERT INTO product (name, price, total,color,desc1,category) VALUE (?,?,?,?,?,?);";
		try {
			PreparedStatement statement = connection.prepareStatement(sql_insert);
			statement.setString(1, product.getName());
			statement.setInt(2,    product.getPrice());
			statement.setInt(3,    product.getTotal());
			statement.setString(4, product.getColor());
			statement.setString(5, product.getDesc());
			statement.setInt(6,    product.getCategory());
			statement.execute();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Override
	public void update(Product product) {
		Connection connection = Database.CreateConnection();
		String sql_update = "UPDATE product SET name=?, price=?, total=?,color=?,desc1=?,category=? WHERE id=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql_update);
			statement.setString(1, product.getName());
			statement.setInt(2,    product.getPrice());
			statement.setInt(3,    product.getTotal());
			statement.setString(4, product.getColor());
			statement.setString(5, product.getDesc());
			statement.setInt(6,    product.getCategory());
			statement.setInt(7,    product.getId());
			statement.execute();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {
		Connection connection = Database.CreateConnection();
		String sql_delete = "DELETE FROM product WHERE id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql_delete);
			statement.setString(1, id);
			statement.execute();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Override
	public List<Product> findAll() {
		List<Product> lists = new ArrayList<>();
		Connection connection = Database.CreateConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM product");
			ResultSet resultSet= statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int price = resultSet.getInt("price");
				int total = resultSet.getInt("total");
				String color = resultSet.getString("color");
				String desc1 = resultSet.getString("desc1");
				int category = resultSet.getInt("category");
				lists.add(new Product(id, name, price, total,color,desc1,category));
			}

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return lists;
	}

	@Override
	public List<Product> findName(String search) {
		List<Product> lists =new ArrayList<>();
		Connection connection = Database.CreateConnection();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM product WHERE name LIKE '%" + search + "%' ");
			while (resultSet.next()){
				Product product = new Product(resultSet);
				lists.add(product);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return lists;
	}
}
