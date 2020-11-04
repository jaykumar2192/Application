package com.app.ecom.row.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.app.ecom.pojo.Categories;

public class CategoriesRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException, DataAccessException {
		Categories categories = new Categories();
		categories.setId(rs.getInt(1));
		categories.setName(rs.getString(2));
		categories.setSellerId(rs.getInt(3));
		return categories;
	}
}
