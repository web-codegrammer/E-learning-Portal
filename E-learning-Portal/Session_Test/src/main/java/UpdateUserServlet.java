//import java.io.IOException;
//import java.sql.SQLException;
//import java.sql.Date;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.amdocs.project.dao.UserDAO;
//import com.amdocs.project.dao.impl.UserDAOIMPL;
//import com.amdocs.project.model.User;
//
//public class UpdateUserServlet extends HttpServlet {
//	private UserDAO UserDAO;
//	
//	public void init() {
//		UserDAO = new UserDAOIMPL();
//	}
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String action = request.getServletPath();
//	}
//
//	private void updateUser(HttpServletRequest request, HttpServletResponse response, String date) 
//				throws SQLException, IOException {
//			long phone=Long.parseLong(request.getParameter("phone"));
//            int user_ID = Integer.parseInt(request.getParameter("user_ID"));
//            String name = request.getParameter("name");
//            String email = request.getParameter("email");
//            String address = request.getParameter("address");
//            String date = request.getParameter("date");
//            String password = request.getParameter("email");
//            String image = request.getParameter("email");
//            User user = new User(name,email,password,address,phone,image,user_ID,date);
//            UserDAO.updateUser(user);
//			response.sendRedirect("list");
//		}
//}
