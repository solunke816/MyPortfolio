package Jdbc_CRUD_Opration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete_data {
public static void main(String[]args) {
  try {
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","admin@123");
	Statement stmt=conn.createStatement();
	String query="Delete from student where ID=7";
	
	stmt.execute(query);
	System.out.println("Data Deleted...!!");
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}
