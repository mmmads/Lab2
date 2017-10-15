package action;



import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class UpdateBookAction extends ActionSupport{
	
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
		ActionContext.getContext().put("ISBN",ISBN);
		return "u_b";
	}

}