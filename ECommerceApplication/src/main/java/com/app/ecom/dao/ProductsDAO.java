package com.app.ecom.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.ecom.pojo.Products;
import com.app.ecom.pojo.UserCartDetails;
import com.app.ecom.row.mappers.ProductsRowMapper;

@Repository
public class ProductsDAO implements BaseDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${sql.create.products}")
	private String createProduct;

	@Value("${sql.get.products.byId}")
	private String getProductsById;

	@Value("${sql.get.products.byName}")
	private String getProductsByName;

	@Value("${sql.get.products}")
	private String getAllProducts;

	@Value("${sql.update.product.quantities.byId}")
	private String updateProductQuantities;

	@Override
	public int create(Object obj) {
		Products product = (Products) obj;
		return jdbcTemplate.update(createProduct,
				new Object[] { product.getId(), product.getName(), product.getDescription(), product.getPrice(),
						product.getQuantity(), product.getRating(), product.getSellerId(), product.getSellerId() });

	}

	@Override
	public List<Products> getAll() {
		return jdbcTemplate.query(getAllProducts, new ProductsRowMapper());
	}

	@Override
	public List<Products> get(int productId) {
		return jdbcTemplate.query(getProductsById, new Object[] { productId }, new ProductsRowMapper());
	}

	@Override
	public List<Products> get(String productName) {
		return jdbcTemplate.query(getProductsByName, new Object[] { productName }, new ProductsRowMapper());
	}

	@Override
	public int update(Object userCartDetails) {
		UserCartDetails cart = (UserCartDetails) userCartDetails;
		return jdbcTemplate.update(updateProductQuantities, new Object[] { cart.getQuantity(), cart.getProductId() });
	}

	@Override
	public int delete(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
