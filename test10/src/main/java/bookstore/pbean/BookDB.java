package bookstore.pbean;


import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class BookDB extends MySQLDAO {
	  public List<TBook> getListbook() throws Exception{
		    String sql = "SELECT id,isbn,title,author,published,price FROM t_book";
	    	PreparedStatement statement = connection.prepareStatement(sql);
	    	ResultSet rs = statement.executeQuery();
	    	List<TBook> list = new ArrayList<TBook>();
	    	while(rs.next()){
	    		TBook todo = new TBook();
	    		todo.setIsbn(rs.getString("isbn"));
	        	todo.setTitle(rs.getString("title"));
	        	todo.setAuthor(rs.getString("author"));
	        	todo.setPublished(rs.getString("published"));
	        	todo.setPrice(rs.getInt("price"));
	        	list.add(todo);
	        }
	        return list;
	    }

}
/*	  
public static TBook findBookByISBN(String inISBN){
	TBook returnValue ;
	return (returnValue);
}
}
	  */