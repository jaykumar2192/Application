package com.app.ecom.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.ecom.pojo.Seller;
import com.app.ecom.row.mappers.SellerRowMapper;

@Repository
public class SellerDAO implements BaseDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${sql.create.seller}")
	private String createSeller;

	@Value("${sql.get.seller}")
	private String getSellers;

	@Override
	public int create(Object object) {

		Seller seller = (Seller) object;
		return jdbcTemplate.update(createSeller, new Object[] { seller.getId(), seller.getName() });
	}

	@Override
	public List<Seller> getAll() {
		return jdbcTemplate.query(getSellers, new SellerRowMapper());
	}

	@Override
	public Object get(String name) {
		return null;
	}

	@Override
	public Object get(int id) {
		return null;
	}

	@Override
	public int update(Object obj) {
		return 0;
	}

	@Override
	public int delete(Object obj) {
		return 0;
	}
}
