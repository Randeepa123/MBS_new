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
import Models.adminCreatemodel;
import Utill.ImageUpload;

/**
 * Servlet implementation class imageuploadServelet
 */
@MultipartConfig
@WebServlet("/imageuploadServelet")
public class imageuploadServelet extends HttpServlet {
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
		
		
		String name=request.getParameter("movieName");
		String shortDes=request.getParameter("shortDescription");
		String LongDes=request.getParameter("longDescription");
		Part image=request.getPart("movieImage");
		Part movie=request.getPart("movieFile");
		
		String imageName=image.getSubmittedFileName();
		String movieName=movie.getSubmittedFileName();
		
		ImageUpload.Filehandle(movie, movieName, image, imageName);
		
		boolean isTrue=adminCreatemodel.CreateMovie(name, shortDes, LongDes, imageName, movieName);
		
		if(isTrue==true) {
			
			RequestDispatcher dis=request.getRequestDispatcher("AdminmovieShowcontroller");
			dis.forward(request, response);
		}
		
		else {
			System.out.println("error!");
		}
		
		
		
		
		
		
	}

}
