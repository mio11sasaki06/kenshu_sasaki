package bookstore.action;

import java.util.Arrays;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;

import bookstore.pbean.BookDB;
import bookstore.pbean.TBook;

@Results({@Result(name="addtocart", location="bookstore.jsp"), 
	      @Result (name="checkout", location="checkout.jsp")})
public class AddToCartAction implements ServletRequestAware{
	private List<TBook> lblist;
	private HttpServletRequest request;
	
	private String[] selecteditems = null;
	
	@Action("/AddToCart")
	public String addToCart() throws Exception{
		HttpSession session = request.getSession();
		session.removeAttribute("CART");
		
		if(selecteditems != null && selecteditems.length != 0){
			List<String> cart = Arrays.asList(selecteditems);
			session.setAttribute("CART", cart);
		}
			 BookDB dao = new BookDB();
			 try{
				dao.getConnection();
				lblist = dao.getListbook();
				return ("addtocart");
			} catch(Exception e) {
				throw new Exception(e); 
			 } finally {
			    dao.closeConnection();
		      }	
	}


	
	/*public String checkout() {
		HttpSession httpsession = request.getSession(false);
		String SQLcart = "SELECTED_ITEM";
		List<String> cart = session.getAttribute("CART");
		for(String ISBN : cart){
			SQLcart += ISBN + "";
		}
		request.setAttribute("TOTAL", total);
		   return ("checkout");
	}
	*/
	public List<TBook> getLblist(){
		return lblist;
	}
	public void setLblist(List<TBook> lblist){
		this.lblist=lblist;
	}
	
	
	public String[] getSelecteditems(){
		return selecteditems;
	}
	public void setSelecteditems(String[] selecteditems){
		this.selecteditems=selecteditems;
	}

	public void setServletRequest (HttpServletRequest request){
		this.request=request;
	}
}
	