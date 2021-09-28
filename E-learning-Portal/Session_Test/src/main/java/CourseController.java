import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.rmi.CORBA.UtilDelegate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.project.dao.CourseDAO;
import com.amdocs.project.dao.impl.CourseDAOIMPL;
import com.amdocs.project.model.Course;

@WebServlet("/course_details")
public class CourseController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String desc=req.getParameter("desc");
		String resource=req.getParameter("resource");
		int fee=Integer.parseInt(req.getParameter("fee"));
		
		CourseDAO dao=new CourseDAOIMPL();
		Course course=new Course(name,id,resource,desc,fee);
		boolean status=dao.saveCourse(course);
		if(status) {
			out.println("Course Added Successfully!");
			out.println("<br><br><a href= 'http://localhost:6060/Session_Test/AdminServlet'>Home</a>");
		}
		else {
			out.println("Try again !");
		}
		
	}

}