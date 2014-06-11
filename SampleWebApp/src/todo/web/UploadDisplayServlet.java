package todo.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.dao.TodoDao;

/**
 * Servlet implementation class UploadDisplayServlet
 */
@WebServlet("/todo/preUpload")
public class UploadDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String idString = request.getParameter("id");	
		int id = Integer.parseInt(idString);
		request.setAttribute("id", id);
		request.getRequestDispatcher("/upload.jsp").forward(request, response);
	}
	}

