package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
	
	private Connection con;
	
	public LoginDAO() throws Exception {
		getConnection();
	}
	
	public boolean validation(String id, String pw) throws Exception{
		if(con == null){
			getConnection();
		}
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try{
			String sql = "SELECT login_pw FROM login WHERE login_id = ?";

			st = con.prepareStatement(sql);
			st.setString(1, id);
			rs = st.executeQuery();
			String target_pw = "";
			while(rs.next()){
				target_pw = rs.getString("login_pw");
			}
			return target_pw.equals(pw) ? true : false;
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(st != null) st.close();
				close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	private void close() throws Exception {
		if(con != null) {
			con.close();
			con = null;
		}
	}
	
	private void getConnection() throws Exception {
		try{
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql:isko";
			String user = "postgres";
			String pass = "himitu";
			con = DriverManager.getConnection(url,user,pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
