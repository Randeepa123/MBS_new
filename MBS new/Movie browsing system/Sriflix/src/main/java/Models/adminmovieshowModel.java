package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Data_access.Movie;
import Utill.DBcon;

public class adminmovieshowModel {
	
	static Connection con;
	static Statement stmt;
	static ResultSet rSet;
	
	
	
	public static List<Movie>showmovie(){
		
		ArrayList<Movie> movies=new ArrayList<>();
		
		try {
			con=DBcon.DBconnection();
			stmt=con.createStatement();
			String sql="SELECT * from movies";
			rSet=stmt.executeQuery(sql);
			
			while(rSet.next()) {
				
				int id=rSet.getInt(1);
				String name=rSet.getString(2);
				String imagepath=rSet.getString(3);
				String shortdescription=rSet.getString(4);
				String longdescription=rSet.getString(5);
				String moviepath=rSet.getString(6);
				
				Movie movie=new Movie(id, name, imagepath, shortdescription, longdescription, moviepath);
				
				movies.add(movie);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return movies;
		
	}

}
