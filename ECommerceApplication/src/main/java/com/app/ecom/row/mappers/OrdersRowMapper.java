package com.app.ecom.row.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.app.ecom.pojo.Orders;

public class OrdersRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException, DataAccessException {
		Orders orders = new Orders();
		orders.setId(rs.getInt(1));
		orders.setTotalAmount(rs.getInt(2));
		orders.setUserId(rs.getInt(3));
		orders.setProductId(rs.getInt(4));
		orders.setOrderDate(rs.getDate(5));
		orders.setQuantity(rs.getInt(6));
		orders.setPaymentInfo(rs.getString(7));
		orders.setOrderStatus(rs.getString(8));

		return orders;
	}
	// "ID","TOTAL_AMOUNT","USER_ID","PRODUCT_ID","ORDER_DATE","QUANTITY","PAYMENT_INFO","ORDER_STATUS"

}
