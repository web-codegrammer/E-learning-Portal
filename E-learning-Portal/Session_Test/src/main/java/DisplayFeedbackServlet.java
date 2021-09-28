import java.io.IOException;  
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

import com.amdocs.project.dao.FeedbackDAO;
import com.amdocs.project.dao.impl.FeedbackDAOIMPL;
import com.amdocs.project.model.Feedback;

 
public class DisplayFeedbackServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                      throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        HttpSession session=request.getSession(false);  
        if(session!=null){  
        	FeedbackDAO dao=new FeedbackDAOIMPL();
        	List<Feedback>list=null;
        	if((boolean) session.getAttribute("is_admin"))
        	{
        		list=dao.display();
        	}
        	else {
        		list=dao.display((int)session.getAttribute("id"));
        	}
        	request.setAttribute("list", list);
        	request.getRequestDispatcher("feedback_display.jsp").forward(request, response);
        }  
        else{  
            out.print("Please login first");  
            request.getRequestDispatcher("login.html").include(request, response);  
        }  
        out.close();  
    }  
}