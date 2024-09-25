package Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data_access.Movie;
import Models.adminmovieshowModel;

/**
 * Servlet implementation class AdminmovieShowcontroller
 */
@WebServlet("/AdminmovieShowcontroller")
public class AdminmovieShowcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Reuse the logic from doPost if necessary
        doPost(request, response);  // You can call doPost if the logic is the same
        
        // Or, if you need different logic, implement it here
        // List<Movie> movieList = MovieDAO.getAllMovies();
        // request.setAttribute("movieDetails", movieList);
        // RequestDispatcher dispatcher = request.getRequestDispatcher("movies.jsp");
        // dispatcher.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		try {
			List<Movie> movieDetails=adminmovieshowModel.showmovie();
			request.setAttribute("movieDetails", movieDetails);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("admin_Home.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
