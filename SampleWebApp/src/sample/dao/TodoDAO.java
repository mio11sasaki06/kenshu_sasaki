package sample.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sample.entity.Todo;




public class TodoDAO extends MySQLDAO {
	  public List<Todo> select() throws Exception{
		  String sql = "SELECT id,title,task,limitdate,lastupdate, userid, label,td.status FROM todo_list td LEFT JOIN status_list stts ON stts.status = td.status";
	    	PreparedStatement statement = connection.prepareStatement(sql);
	    	statement.setString (1, "USER"); 
	    	ResultSet rs = statement.executeQuery();
	    	List<Todo> returnList = new ArrayList<Todo>();
	    	while(rs.next()){
	        	Todo todo = new Todo();
	        	todo.setTitle(rs.getString("title"));
	        	todo.setTask(rs.getString("task"));
	        	todo.setLimitdate(rs.getTimestamp("limitdate"));
	        	todo.setLastupdate(rs.getTimestamp("lastupdate"));
	        	todo.setUserid(rs.getString("userid"));
	        	todo.setStatus(rs.getInt("status"));
	        	returnList.add(todo);
	        }
	        return returnList;
	    }

	  }

