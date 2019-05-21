package myproject.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myproject.beans.User;
import myproject.dao.UserDao;

/**
 * Servlet implementation class Register
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Register" })
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String id=request.getParameter("id");
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		
		long phoneNumber=Long.parseLong(request.getParameter("phoneNumber"));
		
//		System.out.println(phoneNumber);
		String gender=request.getParameter("gender");
		
		
		User bean=new User();
		bean.setId(id);
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setEmailId(email);
		bean.setPassword(password);
		bean.setAddress(address);;
		bean.setPhoneNumber(phoneNumber);
		bean.setGender(gender);
		// checks if email already exists
		boolean status=UserDao.verify(email);
//		System.out.println(phoneNumber);
		if(status==false) {
//			System.out.println(phoneNumber);
		int i=UserDao.save(bean);
//		System.out.println(phoneNumber);
		if(i>0) {
			HttpSession session=request.getSession(true);
			User u=UserDao.getRecoredByEmail(email);
			session.setAttribute("user", u);
//			RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
//			rd.forward(request, response);
			response.sendRedirect("welcome.jsp");
		}else {
			RequestDispatcher rd1=request.getRequestDispatcher("loginform.jsp");
			rd1.include(request, response);
		}
		
		}else {
			RequestDispatcher rd3=request.getRequestDispatcher("register_errorpage.jsp");
			rd3.forward(request, response);

			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
