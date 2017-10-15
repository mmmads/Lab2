package action;

import com.opensymphony.xwork2.ActionSupport;


import dao.BookDao;

public class UpdateAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public String getPublishDate() {
		return PublishDate;
	}
	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		this.Price = price;
	}
	

	public String getAuthorName() {
		return AuthorName;
	}
	public void setAuthorName(String authorName) {
		AuthorName = authorName;
	}
	

	private String AuthorName;
	private String Publisher;
	private String PublishDate;
	private double Price;
	private String ISBN;


	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		BookDao bookDao=new BookDao();
		bookDao.UpdateBook(ISBN, AuthorName, Publisher, PublishDate, Price);
		return "update";
	}
	

}
