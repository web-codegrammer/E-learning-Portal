import java.io.IOException;  
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class UserCourseServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                      throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        HttpSession session=request.getSession(false);  
        if(session!=null){  
        		if(request.getParameter("id")!=null) {
                    int in=Integer.parseInt(request.getParameter("id"));
                    Course_EnrollDAO dao=new Course_EnrollDAOIMPL();
                    boolean status=dao.enroll((int)session.getAttribute("id"), in);
                    if(status) {
            			out.println("Enrolled Successfully in the Course!");
            			out.println("<br><br><a href= 'http://localhost:6060/Session_Test/ProfileServlet'>Home</a>");
            		}
            		else {
            			out.println("Try again !");
            		} 
                }
        		else {
        			Course_EnrollDAO dao=new Course_EnrollDAOIMPL();
        			CourseDAO dao2=new CourseDAOIMPL();
                	List<Integer>list=dao.display((int) session.getAttribute("id"));
                	List<Course>list2=new ArrayList<Course>();
                	for(int i=0;i<list.size();i++) {
                		Course course=dao2.display(list.get(i));
                		System.out.println(course.getCourseID());
                		list2.add(course);
                	}
                	request.setAttribute("list", list2);
                	request.getRequestDispatcher("course_display_user.jsp").forward(request, response);
        		}
        	}
        
        else{  
            out.print("Please login first");  
            request.getRequestDispatcher("login.html").include(request, response);  
        }  
        out.close();  
    }  
}