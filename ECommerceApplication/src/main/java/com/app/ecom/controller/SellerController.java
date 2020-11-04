package com.app.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ecom.exception.ProductException;
import com.app.ecom.exception.SellerException;
import com.app.ecom.exception.UserException;
import com.app.ecom.pojo.Categories;
import com.app.ecom.pojo.Products;
import com.app.ecom.pojo.Seller;
import com.app.ecom.service.SellerService;

@RestController
@RequestMapping("/seller")
public class SellerController {

	@Autowired
	SellerService sellerService;

	@PostMapping("/createSeller")
	public String createSeller(@RequestBody Seller seller) throws SellerException {

		String response = sellerService.createSeller(seller);
		if (response != null)
			return response;
		throw new SellerException("Failed to create seller");
	}

	@GetMapping("/getSeller")
	public List<Seller> getSeller() {

		return sellerService.getAllSeller();
	}

	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Products product) throws ProductException {

		String response = sellerService.addProduct(product);
		if (response != null)
			return response;
		throw new ProductException("Failed to add product " + product.getName());
	}

	@GetMapping("/getProducts")
	public List<Products> getAllProducts() {
		return sellerService.getAllProducts();
	}

	@GetMapping("/getAllCategories")
	public List<Categories> getCartByUserID() throws UserException {
		return sellerService.getAllCategories();
	}

	@PostMapping("/createCategory")
	public String createCategory(@RequestBody Categories category) throws SellerException {

		String response = sellerService.createCategory(category);
		if (response != null)
			return response;
		throw new SellerException("Failed to create seller");
	}
}
