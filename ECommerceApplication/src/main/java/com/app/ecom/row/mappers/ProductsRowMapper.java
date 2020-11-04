package com.app.ecom.row.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.app.ecom.pojo.Products;

public class ProductsRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException, DataAccessException {
		Products product = new Products();
		product.setId(rs.getInt(1));
		product.setName(rs.getString(2));
		product.setDescription(rs.getString(3));
		product.setPrice(rs.getInt(4));
		product.setQuantity(rs.getInt(5));
		product.setRating(rs.getInt(6));
		product.setSellerId(rs.getInt(7));
		product.setCategoryId(rs.getInt(8));
		return product;
	}
}

//"ID","NAME","DESCRIPTION","PRICE","QUANTITY","RATING","SELLER_ID","CATEGORY_ID"
