package com.app.ecom.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.ecom.pojo.Categories;
import com.app.ecom.row.mappers.CategoriesRowMapper;

@Repository
public class CategoriesDAO implements BaseDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${sql.create.categories}")
	private String createCategories;

	@Value("${sql.get.categories}")
	private String getAllCategories;

	@Override
	public int create(Object obj) {
		Categories categories = (Categories) obj;
		return jdbcTemplate.update(createCategories,
				new Object[] { categories.getId(), categories.getName(), categories.getSellerId() });
	}

	@Override
	public List<Categories> getAll() {
		return jdbcTemplate.query(getAllCategories, new CategoriesRowMapper());
	}

	@Override
	public Object get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
