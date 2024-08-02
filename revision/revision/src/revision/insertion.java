package revision;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insertion {

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
			System.out.println("Enter table name");
			String sql = "insert into "+scr.next()+" (name,branch) values (?,?)";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter name");
			pmst.setString(1, scr.next());
			System.out.println("Enter branch");
			pmst.setString(2, scr.next());
			int i = pmst.executeUpdate();
			if(i==1) {
				System.out.println("Data inserted successfully");
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
