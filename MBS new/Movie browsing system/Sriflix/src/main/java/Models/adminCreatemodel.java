package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import Utill.DBcon;


public class adminCreatemodel {
	

	static Connection con;
	static PreparedStatement stmt;
	static boolean isTrue=false;
	 
	
	public static Boolean CreateMovie(String name,String shortDes,String LongDes,String imageName,String movieName) {
	
	try {
	con=DBcon.DBconnection();
	String sql="Insert into movies(MovieName, MovieImgPath, MovieShortdes, MovieLongdes, MoviePath) Values(?,?,?,?,?)";
	stmt=con.prepareStatement(sql);
	
	
	stmt.setString(1, name);
	stmt.setString(3, shortDes);
	stmt.setString(4, LongDes);
	stmt.setString(2, imageName);
	stmt.setString(5, movieName);
	
	int row=stmt.executeUpdate(); 
	

		if (row>0) {
			isTrue=true;
		}else {
			isTrue=false;
		}
		
			}catch (Exception e) {
				e.printStackTrace();
	}
	
	return isTrue;
	
		
	} 

}
