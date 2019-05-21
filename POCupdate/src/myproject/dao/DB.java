package myproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	public static Connection getCon(){
		Connection con=null;
		try{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/admin","postgres", "qwerty");
		}catch(Exception ex){System.out.println(ex);}
		return con;
	}

}
