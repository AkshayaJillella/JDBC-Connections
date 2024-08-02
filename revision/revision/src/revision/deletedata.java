package revision;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class deletedata {

	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	private static final String Url = "";
	private static final String Username = "root";
	private static final String Password = "root";
	private static Connection conn;
	private static PreparedStatement pmst;
	
	public static void main(String[] args) {
		
		Scanner scr = new Scanner(System.in);
		try {
			System.out.println("Enter Database name");
			
			String Url = "jdbc:mysql://localhost:3306/"+scr.next();
			
			Class.forName(Driver);
			
			conn = DriverManager.getConnection(Url, Username, Password);
			
			String sql = "delete from "+scr.next()+" where branch=?";
			
			pmst = conn.prepareStatement(sql);
			
			pmst.setString(1, scr.next());
			
			int i = pmst.executeUpdate();
			
			if(i==0) {
				System.out.println("Deleted successfully");
			}
			else {
				System.out.println("Error");
			}
			
			conn.close();
			pmst.close();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
