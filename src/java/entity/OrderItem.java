package entity;

public class OrderItem {
	private int id;
	private int productId;
	private String productName;
	private int quantity = 1;
	private double price;
	private double discount = 0.1f;

	public OrderItem() {
		super();
	}

	public OrderItem(int productId, String productName, double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}
	
	public OrderItem(int id, String productName, int quantity, double price, double discount) {
		super();
		this.id = id;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.discount = discount;
	}

	public OrderItem(int id, int productId, int quantity, double price, double discount) {
		super();
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.discount = discount;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", productId=" + productId + ", productName=" + productName + ", quantity="
				+ quantity + ", price=" + price + ", discount=" + discount + "]";
	}
}
