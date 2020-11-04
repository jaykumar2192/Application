package com.app.ecom.dao;

import java.util.List;

public interface BaseDAO {

	public Object get(String name);

	public Object get(int id);

	public List<?> getAll();

	public int create(Object obj);

	public int update(Object obj);

	public int delete(Object obj);

}
