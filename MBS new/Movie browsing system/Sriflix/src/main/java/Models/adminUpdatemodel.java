package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Utill.DBcon;

public class adminUpdatemodel {
	
	static Connection con;
	static PreparedStatement stmt;
	static boolean isTrue;
	static Statement statement;
	static ResultSet rSet;
	
	public static boolean Updatemodel(int id,String name,String shortDes,String LongDes,String imageName,String movieName) {
		
		try {
			
			con=DBcon.DBconnection();
			String showsql="select * from movies where MovieID = ?";
			statement=con.createStatement();
			stmt=con.prepareStatement(showsql);
			stmt.setInt(1, id);
			rSet=statement.executeQuery(showsql);
			
		while(rSet.next()) {	
			if (name==null) {
				name=rSet.getString(1);
			}
			if (imageName==null) {
				imageName=rSet.getString(2);
			}
			if (shortDes==null) {
				shortDes=rSet.getString(3);
			}
			if (LongDes==null) {
				LongDes=rSet.getString(4);
			}
			if (movieName==null) {
				movieName=rSet.getString(5);
			}
		}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
		con=DBcon.DBconnection();
		String sql="Update movies Set MovieName=?, MovieImgPath=?, MovieShortdes=?, MovieLongdes=?, MoviePath=? Where MovieID=?";
		stmt=con.prepareStatement(sql);
		
		stmt.setString(1, name);          
        stmt.setString(2, imageName);     
        stmt.setString(3, shortDes);     
        stmt.setString(4, LongDes);       
        stmt.setString(5, movieName);     
        stmt.setInt(6, id);
		
		int row=stmt.executeUpdate();
		
		if (row>0) {
			isTrue=true;
		}else {
			isTrue=false;
		}
		
		
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return isTrue;
		
	}
	
	

}
