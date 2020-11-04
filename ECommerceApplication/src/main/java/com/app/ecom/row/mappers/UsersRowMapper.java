package com.app.ecom.row.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.app.ecom.pojo.Users;

public class UsersRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException, DataAccessException {
		Users user = new Users();
		user.setId(rs.getInt(1));
		user.setUsername(rs.getString(2));
		user.setEmail(rs.getString(3));
		user.setAddressLine1(rs.getString(4));
		user.setAddressLine2(rs.getString(5));
		user.setPin(rs.getInt(6));
		return user;
	}
}

//"ID","USERNAME","EMAIL","ADDRESS_LINE1","ADDRESS_LINE2","PIN"
