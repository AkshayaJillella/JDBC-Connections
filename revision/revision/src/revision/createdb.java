package revision;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class createdb {
	public static void main(String[] args) {
		try {
			Scanner scr = new Scanner(System.in);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root", "root");
			System.out.println("Enter Database name");
			String sql = "create database "+scr.next();
			PreparedStatement pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if (i==1) {
				System.out.println("Datebase created successfully");
			}
			else {
				System.out.println("error");
			}
			conn.close();
			pmst.close();
			scr.close();
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}
