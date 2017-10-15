package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.AuthorDao;
import entity.Book;

public class AuthorTitleAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String authorname;
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
 		AuthorDao authordao=new AuthorDao();
 		int AuthorID=authordao.getAuthorIDByName(authorname);
 		ArrayList<Book> booklist = new ArrayList<Book>();
 		booklist=authordao.getAllBooks(AuthorID);	 		
 		ActionContext.getContext().put("booklist",booklist);
 		
		return "a_t";
	}

}
