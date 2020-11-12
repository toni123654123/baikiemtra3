package model;



import dao.category.CategoryDAO;
import dao.category.ICategory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Product {
	private int    id;
	private String name;
	private int    price;
	private int    total;
	private String color;
	private String desc;
	private int category;

	public Product(){
	}

	public Product(String name, int price, int total, String color, String desc, int category) {
		this.name  = name;
		this.price = price;
		this.total = total;
		this.color = color;
		this.desc  = desc;
		this.category = category;
	}

	public Product(ResultSet resultSet) {
		try {
			this.id       = resultSet.getInt("id");
			this.name     = resultSet.getString("name");
			this.price    = resultSet.getInt("price");
			this.total    = resultSet.getInt("total");
			this.color    = resultSet.getString("color");
			this.desc     = resultSet.getString("desc");
			this.category = resultSet.getInt("category");
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getCategory() {
		return category;
	}

	public String nameCategory() {
		ICategory iCategory =new CategoryDAO();
		Category category = iCategory.findByID(this.category);
		String name = category.getName();

		return name;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
