package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Data_access.Movie;
import Utill.DBcon;

public class Moviewatchmodel {
	
	 static Connection con;
	 static Statement stmt;
	 static ResultSet rSet;
	 
	 
	 public static List<Movie>Movieshow(int id){
		 
		 ArrayList<Movie> movie =new ArrayList<>();
		 
		 try {
			
			 con=DBcon.DBconnection();
			 stmt=con.createStatement();
			 String sql="Select * from movies where MovieID="+id;
			 rSet=stmt.executeQuery(sql);
			 
			 while(rSet.next()) {
				 	int Mid=rSet.getInt(1);
					String name=rSet.getString(2);
					String imagepath=rSet.getString(3);
					String shortdescription=rSet.getString(4);
					String longdescription=rSet.getString(5);
					String moviepath=rSet.getString(6);
					
					Movie mv=new Movie(Mid, name, imagepath, shortdescription, longdescription, moviepath);
					movie.add(mv);
			 }
			 
			 
			 
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		return movie; 
	 }
	

}
