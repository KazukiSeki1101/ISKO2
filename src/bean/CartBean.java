package bean;

public class CartBean {
	private String title;
	private int price;
	private int quantity;
	private int code;
	
	public CartBean(String title, int price, int quantity, int code) {
		this.title = title;
		this.price = price;
		this.quantity = quantity;
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}

//public void deleteCart(int itemCode) {
	//items.remove(new Integer(itemCode));
	
//}