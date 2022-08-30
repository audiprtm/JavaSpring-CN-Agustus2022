package com.coursenet.springbasic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursenet.springbasic.dto.OrderRequestDTO;
import com.coursenet.springbasic.dto.OrderResponseDTO;
import com.coursenet.springbasic.entity.Orders;
import com.coursenet.springbasic.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	
	public OrderResponseDTO createOrder(OrderRequestDTO orderRequest) {
		//1. Ngambil dari request DTO
		//2. Mapping ke ORM
		//3. Save
		Orders order = new Orders();
		order.setGoodsName(orderRequest.getGoodsName());
		order = orderRepository.save(order);
		
		OrderResponseDTO orderResponse = new OrderResponseDTO(order);
		return orderResponse;
	}
	
	public void feature_1_buatan_developer_1(){
		//isi fitur 1
		//implementasi baru fitur 1 oleh dev 2
	}
	
	public void feature_2(){
		//isi fitur 2
	}

	public void feature_1() {
		//Fitur 1
		
	}

}
