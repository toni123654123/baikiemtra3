package dao.category;



import model.Category;
import service.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ICategory{
	@Override
	public List<Category> findAlL() {
		List<Category> lists =new ArrayList<>();
		Connection connection = Database.getInstance().getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM category");
			while (resultSet.next()){
				Category category = new Category(resultSet);
				lists.add(category);
			}
			return lists;
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return null;
	}

	@Override
	public Category findByID(int id) {
		Connection connection = Database.getInstance().getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM category WHERE id = ?");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				Category category = new Category(resultSet);
				return category;
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return null;
	}
}
