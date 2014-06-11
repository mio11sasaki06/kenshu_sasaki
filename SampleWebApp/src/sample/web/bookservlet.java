package sample.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/bookservlet")
public class bookservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = null;
		try{
			InitialContext initCtx = new InitialContext();
			DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/dbtest");
			connection = ds.getConnection();
			log("ê⁄ë±ÇäJÇ´Ç‹ÇµÇΩ");
            insert(connection);
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
	public void insert(Connection connection)throws Exception{


	String sql = "INSERT INTO lecture.book(isbn, title, price, publish, published "+") VALUES (?, ?, ?, ?, ?);";

	PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, "A");
		statement.setString(2, "A");
		statement.setInt(3, 1995);
		statement.setString(4, "USER99");
		statement.setString(5, "2012-01-23");
		int count = statement.executeUpdate();
		log("1Ç¬ñ⁄ÇÃí«â¡ÅF" + count);


	}
		}
