package Utill;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBcon {
	
	private static String url="jdbc:mysql://localhost:3306/sriflix";
	private static String username="root";
	private static String password="";
	private static Connection con;
	
	public static Connection DBconnection() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			System.out.println("Database connected!");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Database disconnected!");
		}
		
		return con;
	}
	
	

}


	
