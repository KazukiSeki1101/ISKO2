package bean;

import java.io.Serializable;

public class KensakuBean implements Serializable {
	private int code;
	private String title;
	private int price;
	private String author;
	private String publisher;
	private String category;
	private String recommend;

	public KensakuBean(int code, String title, int price, String author, String publisher, String category,
			String recommend) {
		this.code=code;
		this.title = title;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
		this.category = category;
		this.recommend = recommend;
	}

	public KensakuBean() {

	}

	public KensakuBean(int code, String title, int price) {
		this.code = code;
		this.title = title;
		this.price = price;
	}
	

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

}
