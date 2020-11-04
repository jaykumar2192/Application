package com.app.ecom.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.ecom.pojo.Orders;
import com.app.ecom.row.mappers.OrdersRowMapper;

@Repository
public class OrdersDAO implements BaseDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Value("${sql.create.order}")
	private String createOrder;

	@Value("${sql.get.order.byId}")
	private String getOrdersByUserId;

	@Override
	public int create(Object obj) {
		List<Orders> orderList = (List<Orders>) obj;
		int count = 0;
		for (Orders order : orderList) {
			count += jdbcTemplate.update(createOrder,
					new Object[] { order.getTotalAmount(), order.getUserId(), order.getProductId(),
							order.getOrderDate(), order.getQuantity(), order.getPaymentInfo(),
							order.getOrderStatus() });
		}

		// "TOTAL_AMOUNT","USER_ID","PRODUCT_ID","ORDER_DATE","QUANTITY","PAYMENT_INFO","ORDER_STATUS"
		return count;
	}

	@Override
	public List<Orders> get(int userId) {
		return jdbcTemplate.query(getOrdersByUserId, new Object[] { userId }, new OrdersRowMapper());
	}

	@Override
	public List<Orders> get(String name) {
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
