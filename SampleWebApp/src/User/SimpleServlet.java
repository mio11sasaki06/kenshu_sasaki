package User;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/SimpleServlet")
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
				
				String name1="jspへ渡すメッセージ";
				String name2="jspへ渡さないメッセージ";
				
				request.setAttribute("name1", name1);
				request.setAttribute("name2", name2);
				RequestDispatcher rd=request.getRequestDispatcher("SimpleJSP.jsp");
		rd.forward(request,response);       
		    
			}

		}

