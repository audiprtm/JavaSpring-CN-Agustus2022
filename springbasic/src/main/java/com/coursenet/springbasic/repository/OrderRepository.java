package com.coursenet.springbasic.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coursenet.springbasic.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
	// @Query("SELECT o FROM Orders o WHERE o.goodsName = :goodsName")
	// Optional<Orders> findByGoodsName(@Param("goodsName") String goodsName);

	 Optional<Orders> findByGoodsName(String goodsName);
	
	// Optional<Orders> findByGoodsNameAndReceiverName(String goodsName, String receiverName);

//	@Query(
//			value = "SELECT * FROM orders where goods_name = :goodsName"
//			, nativeQuery = true
//	)
//	Optional<Orders> findByGoodsName(@Param("goodsName") String goodsName);
	
	
}
