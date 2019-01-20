package bean;

import java.io.Serializable;

public class DetailBean implements Serializable {

	private String title;
	private String author;
	private String publisher;
	private String category;
	private String recommend;

	public DetailBean(String title, String author, String publisher, String category, String recommend) {

		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.category = category;
		this.recommend = recommend;
	}

	public DetailBean() {

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
