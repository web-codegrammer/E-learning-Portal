import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

import com.amdocs.project.dao.AdminDAO;
import com.amdocs.project.dao.UserDAO;
import com.amdocs.project.dao.impl.AdminDAOIMPL;
import com.amdocs.project.dao.impl.UserDAOIMPL;
import com.amdocs.project.db.DBUtils;
import com.amdocs.project.model.Admin;
import com.amdocs.project.model.User;  
public class LoginServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                    throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        request.getRequestDispatcher("link.html");
        Connection conn= DBUtils.getConn();
        UserDAO userdao= new UserDAOIMPL();
        AdminDAO admindao=new AdminDAOIMPL();
        
        String name,pass;
		int u_id;
		boolean is_admin=false;
		int id=Integer.parseInt(request.getParameter("id"));    
        String password=request.getParameter("password");  
        User usr=userdao.display(id);
        
        if(usr ==null)
        {
        	Admin admin=admindao.display(id);
        	name=admin.getName();
        	pass=admin.getPassword();
        	u_id=admin.getAdminID();
        	is_admin=true;
        }
        else {
        	name=usr.getName();
        	pass=usr.getPassword();
        	u_id=usr.getUserID();
        }
        if(password.equals(pass)){  
        out.print("Welcome, "+name);  
        HttpSession session=request.getSession();  
        session.setAttribute("id",u_id);  
        session.setAttribute("name",name);  
        if(is_admin)
        {
        	session.setAttribute("is_admin", true);
            response.sendRedirect("http://localhost:6060/Session_Test/AdminServlet");
        }
        else {
        	session.setAttribute("is_admin", false);
            response.sendRedirect("http://localhost:6060/Session_Test/ProfileServlet");
        }
        // request.getRequestDispatcher("/ProfileServlet").include(request, response);
        }  
        else{  
            out.print("Sorry, You have entered wrong username or password!");  
            request.getRequestDispatcher("login.html").include(request, response);  
        }  
        out.close();  
    }  
}