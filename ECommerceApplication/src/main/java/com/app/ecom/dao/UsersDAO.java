package com.app.ecom.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.ecom.pojo.Users;
import com.app.ecom.row.mappers.UsersRowMapper;

@Repository
public class UsersDAO implements BaseDAO {

	@Value("${sql.create.users}")
	private String createUser;

	@Value("${sql.get.users.byUserName}")
	private String findUserByName;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Object user) {
		Users userLocal = (Users) user;
		return jdbcTemplate.update(createUser, new Object[] { userLocal.getId(), userLocal.getUsername(),
				userLocal.getEmail(), userLocal.getAddressLine1(), userLocal.getAddressLine2(), userLocal.getPin() });

	}

	@Override
	public Object get(String name) {
		return jdbcTemplate.query(findUserByName, new Object[] { name }, new UsersRowMapper());
	}

	@Override
	public Object get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> getAll() {
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
