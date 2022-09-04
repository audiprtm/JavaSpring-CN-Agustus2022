package com.coursenet.springbasic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coursenet.springbasic.dto.OrderRequestDTO;
import com.coursenet.springbasic.dto.OrderResponseDTO;
import com.coursenet.springbasic.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/orders")
	public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO orderRequest) {
		return orderService.createOrder(orderRequest);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<OrderResponseDTO>> getOrder(
			@RequestParam(value="id", required=false) Long id
			) {
		return orderService.getOrder(id);
	}
	
	@GetMapping("/ordersByGoodsName")
	public ResponseEntity<OrderResponseDTO> getOrdersByGoodsName(
			@RequestParam(value="name", required=false) String name
			) {
		return orderService.getOrdersByGoodsName(name);
	}
	
	//PUT
	@PutMapping("/orders/{id}")
	public ResponseEntity<OrderResponseDTO> putOrder(
			@PathVariable(value="id") Long id,
			@RequestBody OrderRequestDTO orderRequest) {
		return orderService.putOrder(id, orderRequest);
	}
	
	//PATCH (Edit Sebagian)
	@PatchMapping("/orders/{id}/{receiverAddress}")
	public ResponseEntity<OrderResponseDTO> patchOrderReceiverAddress(
			@PathVariable(value="id") Long id,
			@PathVariable(value="receiverAddress") String receiverAddress) {
		return orderService.patchOrderReceiverAddress(id, receiverAddress);
	}
	
	//DELETE
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<OrderResponseDTO> deleteOrder(
			@PathVariable(value="id") Long id) {
		return orderService.deleteOrder(id);
	}
}
