package action;



import com.opensymphony.xwork2.ActionSupport;
import dao.BookDao;

public class DeleteBookAction extends ActionSupport{
	
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
		bookdao.deleteBookByISBN(ISBN);
		return "d_b";
	}

}
