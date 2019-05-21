package myproject.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
//		
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>Logout</title>");
//		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
//		out.println("<link rel='stylesheet' href='style.css'/>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<div class='container'>");
//		
//		out.println("<h1>Logout Success</h1>");
		HttpSession session=request.getSession();
		session.invalidate();
		response.sendRedirect("logout.jsp");		
//		out.println("</div>");
//		request.getRequestDispatcher("footer.html").include(request, response);
//		out.println("</body>");
//		out.println("</html>");
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
