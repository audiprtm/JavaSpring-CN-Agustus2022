
//Abstraction
public class JNE extends Shipper implements ShipperInterface{
	//Constructor
	public JNE() {
		name = "JNE";
	}
	
	public void sendPackage(Order order) {
		System.out.println("Paket " + order.getGoodsName()
		+ " telah dikirimkan oleh kurir " + name);
	}
}
