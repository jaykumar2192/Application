package com.app.ecom.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.ecom.pojo.UserCartDetails;
import com.app.ecom.pojo.UsersCart;
import com.app.ecom.row.mappers.UserCartDetailsRowMapper;

@Repository
public class UserCartDAO implements BaseDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${sql.create.usersCart}")
	private String createCart;

	@Value("${sql.get.usersCart.byUserId1}")
	private String getCartByUserId;

	@Value("${sql.get.usersCart.byIdAndProductId}")
	private String userCartByIdAndProductId;

	@Value("${sql.remove.usersCart.byUserId}")
	private String deleteFromCart;

	@Override
	public Object get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserCartDetails> get(int userId) {
		return jdbcTemplate.query(getCartByUserId, new Object[] { userId }, new UserCartDetailsRowMapper());
	}

	public int get(int userId, int productId) {
		return jdbcTemplate.queryForObject(userCartByIdAndProductId, new Object[] { userId, productId }, Integer.class);
	}

	@Override
	public List<?> getAll() {
		return null;
	}

	@Override
	public int create(Object obj) {
		try {
			UsersCart userCart = (UsersCart) obj;
			if (get(userCart.getId(), userCart.getProductId()) == 0)
				return jdbcTemplate.update(createCart, new Object[] { userCart.getId(), userCart.getUserId(),
						userCart.getProductId(), userCart.getQuantity() });
			return 0;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return 0;
		}

		// "ID","USER_ID","PRODUCT_ID","QUANTITY"
	}

	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Object obj) {
		return jdbcTemplate.update(deleteFromCart, obj);
	}

}
