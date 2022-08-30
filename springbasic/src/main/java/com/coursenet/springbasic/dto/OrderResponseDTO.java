package com.coursenet.springbasic.dto;

import java.time.LocalDateTime;

import com.coursenet.springbasic.entity.Orders;

public class OrderResponseDTO {
	private long id;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private String goodsName;

	public OrderResponseDTO(Orders order) {
		super();
		this.id = order.getId();
		this.createdAt = order.getCreatedAt();
		this.updatedAt = order.getUpdatedAt();
		this.goodsName = order.getGoodsName();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public void fiturHaris1() {
		// Fitur Haris 1
	}
}
