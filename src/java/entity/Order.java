package entity;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private int id;
	private int customerId;
	private int orderStatus = 1;
	private int storeId;
	private int staffId;
	private List<OrderItem> items = new ArrayList<>();

	public Order() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public Order(int id, int customerId, int orderStatus, int storeId, int staffId, List<OrderItem> items) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.orderStatus = orderStatus;
		this.storeId = storeId;
		this.staffId = staffId;
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerId=" + customerId + ", orderStatus=" + orderStatus + ", storeId="
				+ storeId + ", staffId=" + staffId + ", items=" + items + "]";
	}

	public int getTotalQuantity() {
		int total = 0;
		for (OrderItem orderItem : items) {
			total += orderItem.getQuantity();
		}
		return total;
	}
	
	public float getTotalPrice() {
		float total = 0;
		for (OrderItem orderItem : items) {
			total += orderItem.getQuantity() * orderItem.getPrice();
		}
		return total;
	}

	public void addItems(Product product) {
		for (OrderItem orderItem : items) {
			if (orderItem.getProductId() == product.getProductId()) {
				orderItem.setQuantity(orderItem.getQuantity() + 1);
				return;
			}
		}
		this.items.add(new OrderItem(product.getProductId(), product.getProductName(), product.getListPrice()));
	}
	
	public void removeItem(int productId) {
		if (productId == -1) {
			items.clear();
			return;
		}
		
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getProductId() == productId) {
				items.remove(i);
				return;
			}
		}
	}
}
