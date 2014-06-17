package todo.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.dao.TodoDao;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/todo/search")
public class SearchServlet extends HttpServlet {
       
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      TodoDao dao = new TodoDao();
	      try{
	    	 dao.getConnection();
	    	  List<TodoValueObject> list = dao.todoList();
	    	  request.setAttribute("todoList", list);
	      } catch(Exception e) {
	    	  throw new ServletException(e);
	      } finally {
	    	  dao.closeConnection();
	      }
		RequestDispatcher rd = request.getRequestDispatcher("/search.jsp");
		rd.forward(request, response);
		}
	    	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	             doGet(request, response);
	    	  }
	      }