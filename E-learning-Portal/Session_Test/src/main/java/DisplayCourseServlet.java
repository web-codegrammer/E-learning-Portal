import java.io.IOException;  
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

import com.amdocs.project.dao.CourseDAO;
import com.amdocs.project.dao.Course_EnrollDAO;
import com.amdocs.project.dao.impl.CourseDAOIMPL;
import com.amdocs.project.dao.impl.Course_EnrollDAOIMPL;
import com.amdocs.project.model.Course;  
public class DisplayCourseServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                      throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        HttpSession session=request.getSession(false);  
        if(session!=null){  
        		CourseDAO dao=new CourseDAOIMPL();
            	List<Course>list=dao.display();
            	request.setAttribute("list", list);
            	request.getRequestDispatcher("course_display.jsp").forward(request, response);
        	
        }  
        else{  
            out.print("Please login first");  
            request.getRequestDispatcher("login.html").include(request, response);  
        }  
        out.close();  
    }  
}