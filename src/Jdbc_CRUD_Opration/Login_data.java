package Jdbc_CRUD_Opration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login_data {
	public static void main(String[]args) {
	Connection conn=null;
	Statement stmt=null;
	Scanner sc=new Scanner(System.in);
	System.out.println("Login Page...");
	System.out.println("User name...?");
	String user_name=sc.next();
	System.out.println("Password...?");
	String pass=sc.next();
	try {
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","admin@123");
        stmt=conn.createStatement();
		String query1="select * from users";
		String query2="Insert into users(user_name,pass)values('"+user_name+"','"+pass+"')";
		ResultSet rs=stmt.executeQuery(query1);
		boolean status=false;
		
		while(rs.next()) {
			if(rs.getString(2).equals(user_name)&& rs.getString(3).equals(pass)){
				System.out.println("Login Successfull...!!");
				status=true;		
			}
		}
		if(status==false) {
			stmt.executeUpdate(query2);
			System.out.println("New User added..");
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
