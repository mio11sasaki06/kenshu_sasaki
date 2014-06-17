package todo.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.dao.TodoDao;
import todo.util.SimpleMailSender;



/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/todo/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String task = request.getParameter("task");
		String inputLimitdate = request.getParameter("limitdate");
		String userid = request.getParameter("userid");
		int Status = Integer.parseInt(request.getParameter("status"));
		TodoValueObject vo = new TodoValueObject();
		vo.setId(id);
		vo.setTitle(title);
		vo.setTask(task);
		vo.setInputLimitdate(inputLimitdate);
		vo.setUserid(userid);
		vo.setStatus(Status);

       TodoDao dao = new TodoDao();
       String message = "";
try{
if(id == 0){
	dao.getConnection();
	dao. registerInsert(vo);
	setMessage(request, "�^�X�N�̐V�K�o�^�������������܂���");
	setMessage(request, message);
} else {
	dao.getConnection();
	dao.registerUpdate(vo);
	setMessage(request, "�^�X�N["+id+"]�̍X�V�������������܂���");
	setMessage(request, message);
}
} catch(Exception e) {
	throw new ServletException(e);
}finally{
	dao.closeConnection();
}
String toAddr = "mio.s.yfm@gmail.com";
String fromAddr = "FromAddress@example.com";
String personName = "USERNAME";
String subject = "TODO�Ǘ��A�v���P�[�V��������̕񍐂ł�";
SimpleMailSender mail = new SimpleMailSender();
try{
	mail.sendMessage(toAddr, fromAddr, personName, subject, message);
} catch(Exception e) {
	e.printStackTrace();
}

RequestDispatcher rd = request.getRequestDispatcher("/todo/search");
rd.forward(request, response);
	}


	protected void setMessage(HttpServletRequest request, String message){
		request.setAttribute("massege", message);
	}

}