package action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.AuthorDao;
import dao.BookDao;
import entity.Author;
import entity.Book;

public class BookDetailAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ISBN;
	
	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	



	public String execute() throws Exception {
		// TODO Auto-generated method stub
		BookDao bookdao=new BookDao();
		Book book=bookdao.getBookByISBN(ISBN);
		AuthorDao authordao =new AuthorDao();
		Author author=authordao.getAuthorByAuthorID(book.getAuthorID());
		ActionContext.getContext().put("book",book);
		ActionContext.getContext().put("author",author);
		return "b_d";
	}

}
