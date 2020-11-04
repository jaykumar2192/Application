package com.app.ecom.row.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.app.ecom.pojo.UserCartDetails;

public class UserCartDetailsRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException, DataAccessException {
		UserCartDetails userCart = new UserCartDetails(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
				rs.getInt(5), rs.getInt(6));

		// P.ID, C.USERID, P.NAME, P.DESCRIPTION, P.PRICE, C.QUANTITY
		return userCart;
	}

}
