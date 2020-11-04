package com.app.ecom.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ecom.dao.CategoriesDAO;
import com.app.ecom.dao.OrdersDAO;
import com.app.ecom.dao.ProductsDAO;
import com.app.ecom.dao.UserCartDAO;
import com.app.ecom.dao.UsersDAO;
import com.app.ecom.exception.UserException;
import com.app.ecom.pojo.Categories;
import com.app.ecom.pojo.Orders;
import com.app.ecom.pojo.Products;
import com.app.ecom.pojo.UserCartDetails;
import com.app.ecom.pojo.Users;
import com.app.ecom.pojo.UsersCart;

@Service
public class UserService {

	@Autowired
	ProductsDAO productDAO;

	@Autowired
	UserCartDAO userCartDAO;

	@Autowired
	OrdersDAO ordersDAO;

	@Autowired
	UsersDAO usersDAO;

	@Autowired
	CategoriesDAO categoriesDAO;

	public List<Products> getAllProducts() {
		return productDAO.getAll();
	}

	public List<Products> getAllProducts(String productName) {
		return productDAO.get(productName);
	}

	public String addToCart(UsersCart userCart) throws UserException {
		try {
			int count = userCartDAO.create(userCart);
			if (count == 1)
				return count + " Item added to Cart";
		} catch (Exception ex) {
			throw new UserException("Item already present in Cart");
		}
		return null;
	}

	public List<UserCartDetails> getCartByUserID(Integer userId) {
		return userCartDAO.get(userId);
	}

	public String emptyUserCart(int userId) throws UserException {
		try {
			int no = userCartDAO.delete(userId);
			return no + " Items removed from Cart";
		} catch (Exception ex) {
			throw new UserException("Item already present in Cart");
		}
	}

	public String processOrder(int userId, String paymentInfo) throws UserException {

		StringBuilder inVoice = new StringBuilder("Invoice for User: " + userId + "\n");
		StringBuilder outOfStock = new StringBuilder();
		int totalPrice = 0;

		/*
		 * Get Cart Details for userID
		 * 
		 */
		List<UserCartDetails> userCartInfo = userCartDAO.get(userId);

		/*
		 * Check all the products Availability
		 */

		List<Orders> ordersList = new ArrayList<Orders>();

		for (UserCartDetails userCart : userCartInfo) {

			Products product = productDAO.get(userCart.getProductId()).get(0);
			int quantity = product.getQuantity();

			if (quantity >= userCart.getQuantity()) {
				int total = userCart.getQuantity() * userCart.getPrice();
				totalPrice = totalPrice + total;

				Orders orders = new Orders(total, userCart.getUserId(), userCart.getProductId(), new Date(),
						userCart.getQuantity(), paymentInfo, "Processed");
				ordersList.add(orders);
				inVoice.append(product.getName() + " - " + total + "\n");

			} else {
				outOfStock.append(product.getName() + " went out of stock \n");
			}
		}

		if (outOfStock.length() > 0)
			throw new UserException(outOfStock.toString());
		else
			inVoice.append("Total Price: " + totalPrice);

		/*
		 * Create order in orders table
		 */

		try {
			ordersDAO.create(ordersList);
		} catch (Exception ex) {
			throw new UserException("Failed to create order");
		}

		/*
		 * Update product quantities
		 */
		for (UserCartDetails userCart : userCartInfo) {

			Products product = productDAO.get(userCart.getProductId()).get(0);
			int quantity = product.getQuantity();
			userCart.setQuantity(quantity - userCart.getQuantity());
			productDAO.update(userCart);
		}

		/*
		 * Clear UserCart
		 */
		userCartDAO.delete(userId);

		return inVoice.toString();
	}

	public List<Orders> getOrdersByUserId(int userId) {
		return ordersDAO.get(userId);
	}

	public String createUser(Users user) {
		try {
			int id = usersDAO.create(user);
			if (id > 0)
				return "User " + user.getUsername() + " created";
		} catch (Exception ex) {
			throw new UserException("Failed to create user");
		}
		return null;
	}

	public List<Categories> getAllCategories() {
		return categoriesDAO.getAll();
	}
}
