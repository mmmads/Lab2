package action;


import com.opensymphony.xwork2.ActionSupport;

import dao.BookDao;

//ÃÌº” ÈºÆ
public class AddAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;




	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
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
		Price = price;
	}
	
	private String ISBN;
	private String Title;
	private String Name;
	private int Age;
	private String Country;
	private String Publisher;
	private String PublishDate;
	private double Price;
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		BookDao bookdao=new BookDao();
		bookdao.AddBook(ISBN, Title, Name, Age, Country, Publisher, PublishDate, Price);
		return "add";
	}
	

}
