package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Models.adminUpdatemodel;
import Utill.DBcon;
import Utill.ImageUpload;
@MultipartConfig
/**
 * Servlet implementation class MovieCreateservelet
 */
@WebServlet("/MovieUpdateServelet")
public class MovieUpdateServelet extends HttpServlet {
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
		
		boolean isTrue;
		
		String movieId=request.getParameter("movieId");
		String name=request.getParameter("movieName");
		String shortDes=request.getParameter("shortDescription");
		String LongDes=request.getParameter("longDescription");
		Part image=request.getPart("movieImage");
		Part movie=request.getPart("movieFile");
		
		String imageName=image.getSubmittedFileName();
		String movieName=movie.getSubmittedFileName();
		
		int Id=Integer.parseInt(movieId);
		DBcon.DBconnection();
		ImageUpload.Filehandle(movie, movieName, image, imageName);
		isTrue= adminUpdatemodel.Updatemodel(Id, name, shortDes, LongDes, imageName, movieName);
		
		if (isTrue==true) {
			
			RequestDispatcher dis=request.getRequestDispatcher("AdminmovieShowcontroller");
			dis.forward(request, response);
			
		}else {
			System.out.println("Error!");
		}
		
		
		
		
			
	}

}
