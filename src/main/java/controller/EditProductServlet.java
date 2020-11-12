package controller;


import dao.category.CategoryDAO;
import dao.category.ICategory;
import dao.product.IProduct;
import dao.product.ProductDAO;
import model.Category;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "edit", urlPatterns = "/edit")
public class EditProductServlet extends HomeServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idP = req.getParameter("id");

		String name     = req.getParameter("name");
		String price    = req.getParameter("price");
		String total    = req.getParameter("total");
		String color    = req.getParameter("color");
		String desc     = req.getParameter("desc");
		String category = req.getParameter("category");

		int id = Integer.valueOf(idP);

		Product product = new Product(name, Integer.valueOf(price), Integer.valueOf(total), color, desc, Integer.valueOf(category));

		product.setId(id);
		IProduct iProduct = new ProductDAO();

		iProduct.update(product);


		ICategory iCategory = new CategoryDAO();
		List<Category> lists = iCategory.findAlL();
		req.setAttribute("lists", lists);

		req.setAttribute("product", product);

		RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		IProduct iProduct = new ProductDAO();
		Product product = iProduct.findById(id);

		ICategory iCategory = new CategoryDAO();
		List<Category> lists = iCategory.findAlL();
		req.setAttribute("lists", lists);

		req.setAttribute("product", product);

		RequestDispatcher dispatcher = req.getRequestDispatcher( "edit.jsp");
		dispatcher.forward(req, resp);
	}
}
