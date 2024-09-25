package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.AdminDeleteModel;

/**
 * Servlet implementation class MovieDeleteServelet
 */
@WebServlet("/MovieDeleteServelet")
public class MovieDeleteServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String movieId=request.getParameter("movieId");
		boolean isTrue;
		
		int Id=Integer.parseInt(movieId);
		isTrue=	AdminDeleteModel.Delete(Id);
		
		if (isTrue==true) {
			
			RequestDispatcher dis=request.getRequestDispatcher("AdminmovieShowcontroller");
			dis.forward(request, response);
			
		}
		
		else {
			System.out.println("Error In MovieDeleteServelet");
		}
		
	}

}
