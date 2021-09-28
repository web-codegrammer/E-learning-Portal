import java.io.IOException;  
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

import com.amdocs.project.dao.ContactDAO;
import com.amdocs.project.dao.impl.ContactDAOIMPL;
import com.amdocs.project.model.Contact;
 
public class DisplayContactServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                      throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        HttpSession session=request.getSession(false);  
        if(session!=null){  
        	ContactDAO dao=new ContactDAOIMPL();
        	List<Contact>list=null;
        	if((boolean) session.getAttribute("is_admin")) {
        		list=dao.display();
        	}
        	else {
        		list=dao.display((int)session.getAttribute("id"));
        	}
        	request.setAttribute("list", list);
        	request.getRequestDispatcher("contacts_display.jsp").forward(request, response);
        }  
        else{  
            out.print("Please login first");  
            request.getRequestDispatcher("login.html").include(request, response);  
        }  
        out.close();  
    }  
}