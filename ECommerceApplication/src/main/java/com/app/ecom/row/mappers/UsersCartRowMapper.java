package com.app.ecom.row.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.app.ecom.pojo.UsersCart;

public class UsersCartRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException, DataAccessException {
		UsersCart userCart = new UsersCart();
		userCart.setId(rs.getInt(1));
		userCart.setUserId(rs.getInt(2));
		userCart.setProductId(rs.getInt(3));
		userCart.setQuantity(rs.getInt(4));
		return userCart;
	}

	// "ID","USER_ID","PRODUCT_ID","QUANTITY"
}
