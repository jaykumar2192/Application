package com.app.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.ecom.exception.UserException;
import com.app.ecom.pojo.Categories;
import com.app.ecom.pojo.Orders;
import com.app.ecom.pojo.Products;
import com.app.ecom.pojo.UserCartDetails;
import com.app.ecom.pojo.Users;
import com.app.ecom.pojo.UsersCart;
import com.app.ecom.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/getProducts")
	public List<Products> getAllProducts() {
		return userService.getAllProducts();
	}

	@GetMapping("/getProductsByName")
	public List<Products> getAllProducts(@RequestParam String productName) {
		return userService.getAllProducts(productName);
	}

	@PostMapping("/addToCart")
	public String addToCart(@RequestBody UsersCart userCart) throws UserException {

		String response = userService.addToCart(userCart);
		if (response != null)
			return response;
		throw new UserException("Error adding item to cart");
	}

	@GetMapping("/getCartByUserId")
	public List<UserCartDetails> getCartByUserID(@RequestParam Integer userId) throws UserException {
		return userService.getCartByUserID(userId);
	}

	@GetMapping("/emptyCart")
	public String emptyUserCart(@RequestParam int userId) {
		String response = userService.emptyUserCart(userId);
		if (response != null)
			return response;
		throw new UserException("Error emptying user cart");
	}

	@GetMapping("/processOrder")
	public String processOrder(@RequestParam int userId, @RequestParam String paymentInfo) throws UserException {

		String response = userService.processOrder(userId, paymentInfo);
		if (response != null)
			return response;
		throw new UserException("Error processing Order, please try again");
	}

	@GetMapping("/getOrdersByUserId")
	public List<Orders> getOrdersByUserId(@RequestParam int userId) {
		return userService.getOrdersByUserId(userId);
	}

	@PostMapping("/createUser")
	public String createUser(@RequestBody Users user) {
		return userService.createUser(user);
	}

	@GetMapping("/getAllCategories")
	public List<Categories> getCartByUserID() throws UserException {
		return userService.getAllCategories();
	}

}
