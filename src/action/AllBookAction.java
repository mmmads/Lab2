package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.BookDao;
import entity.Book;

public class AllBookAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception {
		// TODO Auto-generated method stub
 		BookDao bookdao=new BookDao();
 		ArrayList<Book> booklist = new ArrayList<Book>();
 		booklist=bookdao.getALLBook();	 		
 		ActionContext.getContext().put("booklist",booklist);
		return "allbook";
	}

}
