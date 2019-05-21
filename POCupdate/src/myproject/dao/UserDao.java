package myproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import myproject.beans.*;


public class UserDao {
	public static int save(User bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into registered_users (id,first_name,last_name,email_id,password,address,phone_number,gender) values (?,?,?,?,?,?,?,?)");
			ps.setString(1,bean.getId());
			ps.setString(2,bean.getFirstName());
			ps.setString(3,bean.getLastName());
			ps.setString(4,bean.getEmailId());
			ps.setString(5,bean.getPassword());
			ps.setString(6,bean.getAddress());
			ps.setLong(7,bean.getPhoneNumber());
			ps.setString(8,bean.getGender());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		return status;

}
	public static boolean validate(String email,String password){
		boolean status=false;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from registered_users where email_id=? and password=? and status='active'");
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			if(status==true) {
				PreparedStatement psReset=con.prepareStatement("update registered_users set false_login=0 where email_id=?");
				psReset.setString(1, email);
				psReset.executeUpdate();
			}
			else {
				PreparedStatement ps2=con.prepareStatement("select false_login from registered_users where email_id=?");
				ps2.setString(1, email);
				ResultSet rs2=ps2.executeQuery();
				while(rs2.next()) {
					int count=rs2.getInt(1)+1;
					if(count<3) {
					PreparedStatement ps3=con.prepareStatement("update registered_users set false_login=? where email_id=?");
					ps3.setInt(1, count);
					ps3.setString(2, email);
					ps3.executeUpdate();
					}else {
						PreparedStatement ps4=con.prepareStatement("update registered_users set status='disabled' where email_id=?");
						ps4.setString(1, email);
						ps4.executeUpdate();
					}
					
				}
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		return status;
	}	
public static boolean verify(String email) {
	boolean status=false;
	try {
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from registered_users where email_id=?");
		ps.setString(1, email);
		ResultSet rs=ps.executeQuery();
		status=rs.next();
		con.close();
	}catch(Exception e) {System.out.println(e);}
	return status;
}
public static User getRecoredByEmail(String email) {
	User u=new User();
	try {
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from registered_users where email_id=?");
		ps.setString(1, email);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			
			String id=rs.getString(1);
			String firstName=rs.getString(2);
			String lastName=rs.getString(3);
			String emailrs=rs.getString(4);
			String address=rs.getString(8);
			long phoneNumber=rs.getLong(9);
			String gender=rs.getString(10);
			u.setId(id);
			u.setFirstName(firstName);
			u.setLastName(lastName);
			u.setEmailId(emailrs);
			u.setAddress(address);
			u.setPhoneNumber(phoneNumber);
			u.setGender(gender);
		}
		con.close();
	}catch(Exception e) {System.out.println(e);}
	return u;
}
public static boolean checkDisability(String email) {
	boolean status=false;
	try {
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select status from registered_users where email_id=? and status='disabled'");
		ps.setString(1, email);
		ResultSet rs=ps.executeQuery();
		status=rs.next();
		con.close();
	}catch(Exception e) {System.out.println(e);}
	return status;
}
public static List<User> getRegisteredUsers() {
	List<User> list=new ArrayList<User>();
	try {
		Connection con=DB.getCon();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from registered_users");
		while(rs.next()) {
		User u=new User();
		u.setId(rs.getString(1));
		u.setFirstName(rs.getString(2));
		u.setLastName(rs.getString(3));
		u.setEmailId(rs.getString(4));
		u.setPassword(rs.getString(5));
		u.setStatus(rs.getString(6));
		u.setAddress(rs.getString(8));
		u.setPhoneNumber(rs.getLong(9));
		u.setGender(rs.getString(10));
		list.add(u);
		}
		con.close();
	}catch(Exception e) {System.out.println(e);}
//	System.out.println(list);
	return list;
	}
public static void reset(User s) {
	try {
	Connection con=DB.getCon();
	PreparedStatement stmt=con.prepareStatement("update registered_users set status='active' where id=?");
	stmt.setString(1, s.getId());
	stmt.executeUpdate();
	con.close();
	}catch(Exception e) {System.out.println(e);}
}

}				//end of class


