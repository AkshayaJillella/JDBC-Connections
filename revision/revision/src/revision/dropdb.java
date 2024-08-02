package revision;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class dropdb {
	

	public static void main(String[] args) {
		try {
			
			Scanner scr = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "akshaya@123");
			System.out.println("Enter Database name");
			String sql = "drop database "+scr.next();
			PreparedStatement pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if(i==1) {
				System.out.println("Database droped successfully");
			}
			else {
				System.out.println("Error");
			}
			
			conn.close();
			pmst.close();
			scr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
