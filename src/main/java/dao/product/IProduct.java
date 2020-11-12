package dao.product;



import model.Product;

import java.util.List;

public interface  IProduct {
	Product findById(String id);
	void insert(Product product);
	void update(Product product);
	void delete(String id);
	List<Product> findAll();

	List<Product> findName(String search);
}
