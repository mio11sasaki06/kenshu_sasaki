package User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleBeansServlet
 */
@WebServlet("/SimpleBeansServlet")
public class SimpleBeansServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			UserBeans beans=new UserBeans();
			beans.setUsername("サンプル名前");
			beans.setPhone("090-9999-****");
			beans.setAddress("東京都　　区１丁目");
			beans.checkValues();
			request.setAttribute("user", beans);
			request.getRequestDispatcher("UserBeans/jsp").forward(request, response);
			
		}

	}

