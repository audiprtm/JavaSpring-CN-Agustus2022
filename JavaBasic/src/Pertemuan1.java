import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pertemuan1 {
	//Blueprint / Template sebuah objek
	
	//Paket / Order
	
	// class order didalamnya variabel yang menjadi kepunyaan si objek tersebut

	public static void main(String[] args) {
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

	private static void sendPackage(Order order) {
//		if(order.getShipperName().equals("JNE")) {
//			shipper =  new JNE();
//		}else if(order.getShipperName().equals("Sicepat")) {
//			shipper = new Sicepat();
//		}
		
		//Java Collection, Map
		Map<String, ShipperInterface> shipperMap = new HashMap<>();
		shipperMap.put( "JNE", new JNE() );
		shipperMap.put( "Sicepat", Sicepat.getInstance() );
		
		ShipperInterface shipper= shipperMap.get( order.getShipperName() );
		shipper.sendPackage(order);
	}

	private static ShipperInterface mappingShipperInterface(Order orderMeja) {
		if(orderMeja.getShipperName().equals("JNE")) {
			return new JNE();
		}else if(orderMeja.getShipperName().equals("Sicepat")) {
			return new Sicepat();
		}
		
		return null;
	}

	private static void checkOrderStatus(Order orderMeja) {
		System.out.println("Nama Paket " + orderMeja.getGoodsName()
		+ " Nama Penerima " + orderMeja.getReceiverName()
		+ " Kurir yang dipakai " + orderMeja.getShipperName());
	}

}
