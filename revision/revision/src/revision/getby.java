package revision;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class getby {

	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	private static final String Url = "jdbc:mysql://localhost:3306/revision";
	private static final String Username = "root";
	private static final String Password = "root";
	private static Connection conn;
	private static PreparedStatement pmst;
	
	public static void main(String[] args) {
		
		Scanner scr = new Scanner(System.in);
		
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(Url, Username, Password);
			System.out.println("Enter table name");
			String sql = "select * from "+scr.next()+" where name=?";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter name");
			pmst.setString(1, scr.next());
			ResultSet rs = pmst.executeQuery();
			while(rs.next()) {
				System.out.println("id: "+rs.getInt("id"));
				System.out.println("branch: "+rs.getString("branch"));
				System.out.println("name: "+rs.getString("name"));
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
