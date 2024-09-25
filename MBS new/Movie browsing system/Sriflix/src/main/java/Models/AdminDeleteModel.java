package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;


import Utill.DBcon;

public class AdminDeleteModel {
	
	private static Connection con;
	private static PreparedStatement  stmt;
	
	public static boolean isTrue;
	
	public static Boolean Delete(int Id){
		
	try {	
		con=DBcon.DBconnection();
		String sql="Delete From movies where MovieID=?";
		stmt=con.prepareStatement(sql);
		stmt.setInt(1, Id);
		
		
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
