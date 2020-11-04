package com.app.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ecom.dao.CategoriesDAO;
import com.app.ecom.dao.ProductsDAO;
import com.app.ecom.dao.SellerDAO;
import com.app.ecom.exception.ProductException;
import com.app.ecom.exception.SellerException;
import com.app.ecom.pojo.Categories;
import com.app.ecom.pojo.Products;
import com.app.ecom.pojo.Seller;

@Service
public class SellerService {

	@Autowired
	SellerDAO sellerDAO;

	@Autowired
	ProductsDAO productDAO;

	@Autowired
	CategoriesDAO categoriesDAO;

	public String createSeller(Seller seller) throws SellerException {
		try {
			int id = sellerDAO.create(seller);
			if (id > 0)
				return seller.getName() + " with id: " + seller.getId() + " successfully created";
		} catch (Exception ex) {
			throw new SellerException("Failed to create seller");
		}
		return null;
	}

	public List<Seller> getAllSeller() {
		try {
			return sellerDAO.getAll();
		} catch (Exception ex) {
			throw new SellerException(ex.getMessage());
		}
	}

	public String addProduct(Products product) throws SellerException {
		try {
			int no = productDAO.create(product);
			if (no > 0)
				return "Product: " + product.getName() + " successfully added";
		} catch (Exception ex) {
			throw new SellerException("Failed to add product !!");
		}
		return null;
	}

	public List<Products> getAllProducts() throws ProductException {
		try {
			return productDAO.getAll();
		} catch (Exception ex) {
			throw new ProductException("Unable to fetch all products");
		}
	}

	public List<Categories> getAllCategories() {
		return categoriesDAO.getAll();
	}

	public String createCategory(Categories category) {
		try {
			int id = categoriesDAO.create(category);
			if (id > 0)
				return category.getName() + " successfully created";
		} catch (Exception ex) {
			throw new SellerException("Failed to create category");
		}
		return null;
	}

}
