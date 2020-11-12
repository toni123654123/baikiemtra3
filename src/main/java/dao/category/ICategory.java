package dao.category;


import model.Category;

import java.util.List;

public interface ICategory {
	List<Category> findAlL();

	Category findByID(int category);
}
