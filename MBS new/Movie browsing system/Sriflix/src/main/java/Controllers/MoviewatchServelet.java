package Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data_access.Movie;
import Models.Moviewatchmodel;

/**
 * Servlet implementation class MoviewatchServelet
 */
@WebServlet("/MoviewatchServelet")
public class MoviewatchServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		
		List<Movie> movies =Moviewatchmodel.Movieshow(movieId);
		request.setAttribute("Moviewatch", movies);
        
        
        
        request.getRequestDispatcher("Movies.jsp").forward(request, response);
		
		
	}

}
