package todo.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.dao.TodoDao;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/todo/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  TodoDao dao = new TodoDao();
	      String paramId = request.getParameter("id");

        try{
         dao.getConnection();
     	   int id = Integer.parseInt(paramId);
     	   int result = dao.delete(id);

        } catch(Exception e) {
				throw new ServletException(e);
			} finally {
				dao.closeConnection();
			}

        setMessage(request, "É^ÉXÉN["+paramId+"]ÇÃçÌèúèàóùÇ™äÆóπÇµÇ‹ÇµÇΩ");

        RequestDispatcher rd = request.getRequestDispatcher("/todo/search");
        rd.forward(request, response);
        }
	  protected void setMessage(HttpServletRequest request, String message){
		  request.setAttribute("massege", message);
	  }
}
