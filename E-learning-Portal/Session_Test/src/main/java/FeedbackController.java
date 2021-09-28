import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.rmi.CORBA.UtilDelegate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.project.dao.FeedbackDAO;
import com.amdocs.project.dao.impl.FeedbackDAOIMPL;
import com.amdocs.project.model.Feedback;



@WebServlet("/feedback")
public class FeedbackController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String feedback=req.getParameter("feedback");
		//out.println(id+name+email+feedback);
		
		FeedbackDAO dao=new FeedbackDAOIMPL();
		Feedback feedback_o=new Feedback(id,name,email,feedback);
		boolean status=dao.saveFeedback(feedback_o);
		if(status) {
			out.println("Feedback Submitted Successfully !");
			out.println("<br><br><a href= 'http://localhost:6060/Session_Test/ProfileServlet'>Home</a>");
		}
		else {
			out.println("Please Try again !");
		}
		out.close();
	}

}
