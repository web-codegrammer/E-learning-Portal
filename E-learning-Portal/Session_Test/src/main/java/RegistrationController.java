import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.project.dao.UserDAO;
import com.amdocs.project.dao.impl.UserDAOIMPL;
import com.amdocs.project.model.User;

@WebServlet("/register")
public class RegistrationController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		long phone=Long.parseLong(request.getParameter("phone"));
		String address=request.getParameter("address");
		String photo=request.getParameter("photo");
		
		UserDAO dao = new UserDAOIMPL();
		long millis=System.currentTimeMillis();  
		Date date=new Date(millis);
		User user=new User(name,email,password,address,phone,photo,id,date);
		boolean status=dao.saveUser(user);
		if(status) {
			out.println("User Saved Successfully!");
			//req.getRequestDispatcher("index.html");
			//resp.sendRedirect("http://localhost:6060/Session_Test");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		else {
			out.println("Try again or you already have inserted this data !");
		}
		out.close();
	}

}
