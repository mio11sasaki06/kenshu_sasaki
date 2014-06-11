package sample.beans;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import todo.web.TodoValueObject;



@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection=null;
		try{
			InitialContext initCtx = new InitialContext();
			DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/dbtest");
			connection=ds.getConnection();

			log("ê⁄ë±ÇäJÇ´Ç‹ÇµÇΩ");

			List<TodoValueObject> resultList = select(connection);
			request.setAttribute("list", resultList);
			request.getRequestDispatcher("list.jsp").forward(request, response);

				}catch(Exception e){
					throw new ServletException(e);
				}finally{
					try{
						connection.close();
						log("ê⁄ë±Çï¬Ç∂Ç‹ÇµÇΩ");
				}catch(SQLException e){
					throw new ServletException(e);
				}
			}
	}

	  public List<TodoValueObject> select(Connection connection) throws Exception{
		 String sql = "SELECT title,task,limitdate,lastupdate,userid,status FROM todo_list WHERE userid like CONCAT('%',?,'%')";
		 PreparedStatement statement = connection.prepareStatement(sql);
		 statement.setString(1, "USER");
		 ResultSet rs = statement.executeQuery();
         List<TodoValueObject> resultList = new ArrayList<TodoValueObject>();

         while(rs.next()){
        	 TodoValueObject todo = new TodoValueObject();
            todo.setTitle(rs.getString("title"));
            todo.setTask(rs.getString("task"));
            todo.setLimitdate(rs.getTimestamp("limitdate"));
            todo.setLastupdate(rs.getTimestamp("lastupdate"));
            todo.setUserid(rs.getString("userid"));
            todo.setStatus(rs.getInt("status"));
            resultList.add(todo);
         }
            return resultList;
     }
}

