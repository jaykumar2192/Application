package com.app.ecom.row.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.app.ecom.pojo.Seller;

public class SellerRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException, DataAccessException {
		Seller seller = new Seller();
		seller.setId(rs.getInt(1));
		seller.setName(rs.getString(2));
		seller.setRating(rs.getInt(3));
		return seller;
	}

}
