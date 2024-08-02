package revision;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class createtab {
	
	private static final String Driver ="com.mysql.cj.jdbc.Driver";
	private static final String Url = "";
	private static final String Username = "root";
	private static final String Password = "akshaya@123";
	private static Connection conn;
	private static PreparedStatement pmst;

	public static void main(String[] args) {
		
		Scanner scr = new Scanner(System.in);
		try {
			
			System.out.println("Enter Database name");
			String Url = "jdbc:mysql://localhost:3306/"+scr.next();
			Class.forName(Driver);
			conn = DriverManager.getConnection(Url, Username, Password);
			System.out.println("Enter Table name");
			String sql = "create table "+scr.next()+ " (id int primary key auto_increment, name varchar(30) unique, branch varchar(10) not null)";
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if(i==0) {
				System.out.println("Table created successfully");
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
