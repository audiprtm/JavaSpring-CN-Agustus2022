package com.coursenet.springbasic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.coursenet.springbasic.config.AlgorithmConfig;
import com.coursenet.springbasic.config.KeyConfig;
import com.coursenet.springbasic.pertemuan1.JNE;
import com.coursenet.springbasic.pertemuan1.Order;
import com.coursenet.springbasic.pertemuan1.ShipperInterface;
import com.coursenet.springbasic.pertemuan1.Sicepat;
import com.coursenet.springbasic.util.ShipperMapperUtil;

@SpringBootTest
class SpringbasicApplicationTests {
	@Autowired
	private KeyConfig keyConfig;
	
	@Autowired
	private AlgorithmConfig algorithmConfig;
	
	@Autowired
	private ShipperMapperUtil shipperMapperUtil;
	
	@Test
	void testAutowired() {
		System.out.println(keyConfig.getKey());
		System.out.println(algorithmConfig.getAlgorithmName());
	}
	
	@Test
	void testPertemuan2() {
		Order orderMeja = new Order();
		orderMeja.setGoodsName("Meja Belajar");
		orderMeja.setReceiverName("Audi");
		orderMeja.setReceiverAddress("Tangerang");
		orderMeja.setShipperName("JNE");
						
		Order orderKursi = new Order();
		orderKursi.setGoodsName("Kursi Gaming");
		orderKursi.setReceiverName("Audi");
		orderKursi.setReceiverAddress("Tangerang");
		orderKursi.setShipperName("Sicepat");
		
		Order orderLampu = new Order();
		orderLampu.setGoodsName("Lampu");
		orderLampu.setReceiverName("Audi");
		orderLampu.setReceiverAddress("Tangerang");
		orderLampu.setShipperName("Sicepat");
		
		//Order Lampu
		List<Order> orderList = new ArrayList<>();
		orderList.add(orderMeja);
		orderList.add(orderKursi);
		orderList.add(orderLampu);
		
		for(int i=0; i<orderList.size() ; i++) {
			checkOrderStatus( orderList.get(i) );	
			sendPackage( orderList.get(i) );
			
			System.out.println();
		}
	}
	
	private void sendPackage(Order order) {		
		//Java Collection, Map
		ShipperInterface shipper= shipperMapperUtil.getShipper( order.getShipperName() );
		shipper.sendPackage(order);
	}

	private void checkOrderStatus(Order orderMeja) {
		System.out.println("Hai");
		
		System.out.println("Nama Paket " + orderMeja.getGoodsName()
		+ " Nama Penerima " + orderMeja.getReceiverName()
		+ " Kurir yang dipakai " + orderMeja.getShipperName());
	}

}
