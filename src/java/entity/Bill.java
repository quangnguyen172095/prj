package entity;

public class Bill {
	private int id;
	private String customerName;
	private String date;
	private double total;
	private int status;

	public Bill() {
		super();
	}

	public Bill(int id, String customerName, String date, double total, int status) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.date = date;
		this.total = total;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", customerName=" + customerName + ", date=" + date + ", total=" + total + ", status="
				+ status + "]";
	}

}
