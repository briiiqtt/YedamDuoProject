package co.yedam.cart;

public class Product {
	private String id ;
	private String brand ;
	private String name ;
	private int originprice ;
	private int offprice ;
	private int likeit ;
	private String filename ;
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOriginprice() {
		return originprice;
	}
	public void setOriginprice(int originprice) {
		this.originprice = originprice;
	}
	public int getOffprice() {
		return offprice;
	}
	public void setOffprice(int offprice) {
		this.offprice = offprice;
	}
	public int getLikeit() {
		return likeit;
	}
	public void setLikeit(int likeit) {
		this.likeit = likeit;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
}
