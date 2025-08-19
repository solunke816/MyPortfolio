package Jdbc_CRUD_Opration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert_data{
public static void main(String[]args) {
	
	try {
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee", "root", "admin@123");
    
		// Need too Change values for 
		String query="Insert into student values(7,'Kiran',43,63.32)";
      Statement stmt=conn.createStatement();
      stmt.execute(query);
	    System.out.println("Data stored...!!");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
