package com.coursenet.springbasic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.coursenet.springbasic.dto.OrderRequestDTO;
import com.coursenet.springbasic.dto.OrderResponseDTO;
import com.coursenet.springbasic.entity.Orders;
import com.coursenet.springbasic.pertemuan1.Order;
import com.coursenet.springbasic.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	
	public ResponseEntity<OrderResponseDTO> createOrder(OrderRequestDTO orderRequest) {
		//1. Ngambil dari request DTO
		//2. Mapping ke ORM
		//3. Save
		Orders order = new Orders();
		order.setGoodsName(orderRequest.getGoodsName());
		order.setReceiverAddress(orderRequest.getReceiverAddress());
		order.setReceiverName(orderRequest.getReceiverName());
		
		order = orderRepository.save(order);
		
		OrderResponseDTO orderResponse = new OrderResponseDTO(order);
		return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
	}


	public ResponseEntity<List<OrderResponseDTO>> getOrder(Long id) {
		//Get All
		List<OrderResponseDTO> listOrderResponseDTO = new ArrayList<>();
		
		if (id==null) {
			List<Orders> listOrders = orderRepository.findAll();
			
			for(int i=0;i<listOrders.size();i++) {
				OrderResponseDTO responseDTO = new OrderResponseDTO(listOrders.get(i));
				listOrderResponseDTO.add(responseDTO);
			}
			
			return new ResponseEntity<>(listOrderResponseDTO, HttpStatus.OK);
		}
		
		//Get by Id
		Optional<Orders> order = orderRepository.findById(id);
		
		//Cek data apabila null
		if(!order.isPresent()) {
			return new ResponseEntity<>(listOrderResponseDTO, HttpStatus.NOT_FOUND);
		}
		
		
		OrderResponseDTO responseDTO = new OrderResponseDTO(order.get());
		listOrderResponseDTO.add(responseDTO);
		return new ResponseEntity<>(listOrderResponseDTO, HttpStatus.OK);
	}


	public ResponseEntity<OrderResponseDTO> putOrder(Long id, OrderRequestDTO orderRequest) {
		Optional<Orders> order = orderRepository.findById(id);
		
		//Apabila datanya tidak ada, maka create baru
		if (!order.isPresent()) {
			Orders newOrder = new Orders();
			newOrder.setGoodsName(orderRequest.getGoodsName());
			newOrder.setReceiverAddress(orderRequest.getReceiverAddress());
			newOrder.setReceiverName(orderRequest.getReceiverName());
			
			newOrder = orderRepository.save(newOrder);
			
			OrderResponseDTO orderResponse = new OrderResponseDTO(newOrder);
			return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
		}
		
		//Tapi jika ada, maka edit yang sudah ada
		Orders newOrder = order.get();
		newOrder.setGoodsName(orderRequest.getGoodsName());
		newOrder.setReceiverAddress(orderRequest.getReceiverAddress());
		newOrder.setReceiverName(orderRequest.getReceiverName());
		
		newOrder = orderRepository.save(newOrder);
		
		OrderResponseDTO orderResponse = new OrderResponseDTO(newOrder);
		return new ResponseEntity<>(orderResponse, HttpStatus.OK);
	}


	public ResponseEntity<OrderResponseDTO> patchOrderReceiverAddress(Long id, String receiverAddress) {
		Optional<Orders> orders = orderRepository.findById(id);
		OrderResponseDTO orderResponse;
		
		if (!orders.isPresent()) {
			orderResponse = new OrderResponseDTO();
			return new ResponseEntity<>(orderResponse, HttpStatus.NOT_FOUND); 
		}
		
		Orders newOrder = orders.get();
		newOrder.setReceiverAddress(receiverAddress);
		newOrder = orderRepository.save(newOrder);
		
		orderResponse = new OrderResponseDTO(newOrder);
		return new ResponseEntity<>(orderResponse, HttpStatus.OK); 
	}


//	public ResponseEntity<List<OrderResponseDTO>> getOrdersByName(String name) {
//		// Get by Id
//		List<Orders> order = orderRepository.findOrderByGoodsName(name);
//		List<OrderResponseDTO> listOrderResponseDTO = new ArrayList<>();
//		
//		// Cek data apabila null
//		if (order==null || order.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//
//		for(int i=0;i<order.size();i++) {
//			OrderResponseDTO responseDTO = new OrderResponseDTO(order.get(i));
//			listOrderResponseDTO.add(responseDTO);
//		}
//		
//		return new ResponseEntity<>(listOrderResponseDTO, HttpStatus.OK);
//	}


	public ResponseEntity<OrderResponseDTO> deleteOrder(Long id) {
		Optional<Orders> order = orderRepository.findById(id);
		if (!order.isPresent()) {
			return new ResponseEntity<>(new OrderResponseDTO(), HttpStatus.NOT_FOUND); 
		}
		
		orderRepository.deleteById(id);
		return new ResponseEntity<>(new OrderResponseDTO(), HttpStatus.NO_CONTENT); 
	}


	public ResponseEntity<OrderResponseDTO> getOrdersByGoodsName(String goodsName) {
		Optional<Orders> order = orderRepository.findByGoodsName(goodsName);
		if (!order.isPresent()) {
			return new ResponseEntity<>(new OrderResponseDTO(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new OrderResponseDTO(order.get()), HttpStatus.OK);
	}

}
