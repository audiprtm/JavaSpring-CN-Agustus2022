
public class Sicepat extends Shipper implements ShipperInterface{
	public Sicepat() {
		name = "Sicepat";
	}
	
	private static Sicepat sicepat;
	
	//Apabila belum ada objek sicepat, tolong create objeknya
	//Tapi, jika sudah ada pakai objek yang ada
	
	public static Sicepat getInstance() {
		if (sicepat==null) {
			sicepat = new Sicepat();
		}
		
		return sicepat;
	}
	
	public void sendPackage(Order order) {
		System.out.println("Paket " + order.getGoodsName()
		+ " telah dikirimkan oleh kurir " + name);
	}
}
