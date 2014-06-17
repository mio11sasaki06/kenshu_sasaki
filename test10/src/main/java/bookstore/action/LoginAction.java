package bookstore.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import bookstore.pbean.BookDB;
import bookstore.pbean.TBook;

@Results({ @Result(name="login", location="bookstore.jsp")})
public class LoginAction {
private List<TBook> lblist;

@Action("/Login")
 public String loginAndGetBookList() throws Exception{
	 BookDB dao = new BookDB();
	 try{
		dao.getConnection();
		lblist = dao.getListbook();
		return ("login");
	 } catch(Exception e) {
		throw new Exception(e); 
	 } finally {
	    dao.closeConnection();
      }	
}
public List<TBook> getLblist(){
	return lblist;
}
public void setLblist(List<TBook> lblist){
	this.lblist = lblist;
 }
}