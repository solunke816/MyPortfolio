package Test;

import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDemo1 {
public static void main(String[]args) {
	try {
		DriverManager.getConnection("jdbc:mysql://localhost:3306/ebook-app","root","admin@123");
		System.out.println("connection successful");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
