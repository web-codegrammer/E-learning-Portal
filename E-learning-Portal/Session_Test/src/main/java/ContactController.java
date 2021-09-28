import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.project.dao.ContactDAO;
import com.amdocs.project.dao.impl.ContactDAOIMPL;
import com.amdocs.project.model.Contact;


@WebServlet("/contact_details")
public class ContactController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String message=req.getParameter("message");
		long phone=Long.parseLong(req.getParameter("phone"));
		//out.println(id+name+email+message+phone);
		
		ContactDAO dao=new ContactDAOIMPL();
		Contact contact=new Contact(id,email,name,phone,message);
		boolean status=dao.saveContact(contact);
		if(status) {
			out.println("Contact created Successfully!");
			out.println("<br><br><a href= 'http://localhost:6060/Session_Test/ProfileServlet'>Home</a>");
		}
		else {
			out.println("Try again !");
		}
		out.close();
	}

}
