package myproject.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myproject.beans.User;
import myproject.dao.UserDao;

/**
 * Servlet implementation class LoginHome
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/LoginHome" })
public class LoginHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>Home Page</title>");
//		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
//		out.println("<link rel='stylesheet' href='style.css'/>");
//		out.println("</head>");
//		out.println("<body>");
//		request.getRequestDispatcher("navhome.html").include(request, response);
//		out.println("<div class='container'>");
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		// checks account for status(active or disabled)
		if(UserDao.checkDisability(email)==false) {
			//validates email and  updates false login column of a table resets false login=0 if account is validated
		boolean status=UserDao.validate(email, password);
		if(status==true){
			// fetches record by associated with email
			response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
			response.setHeader("Pragna","no-cache");
			response.setHeader("Expire","0");
			User u=UserDao.getRecoredByEmail(email);
			
			HttpSession session=request.getSession();
			
			session.setAttribute("user",u);
			
			//request.getRequestDispatcher("welcome.jsp").forward(request, response);
			response.sendRedirect("welcome.jsp");
		}else{
//			out.println("<h1>Login error</h1>");
//			out.println("<p>Sorry, username or password error!</p>");
//		
//			request.getRequestDispatcher("errloginform.html").include(request, response);
			response.sendRedirect("loginerror.jsp");
		}
		}else {
			response.sendRedirect("disabledUser.jsp");
			
		}
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");
		
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
