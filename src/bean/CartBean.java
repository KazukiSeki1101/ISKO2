package bean;

import java.awt.ItemSelectable;

public class CartBean {
	private String title;
	private int price;
	private int amount;
	
	public CartBean(String title, int price,int amount) {
		this.title = title;
		this.price = price;
		this.amount = amount;
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}

//public void deleteCart(int itemCode) {
	//items.remove(new Integer(itemCode));
	
//}