package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.KensakuBean;
import hinan.DAOException;

public class KensakuDAO {
	private Connection con;

	public KensakuDAO() throws DAOException {
		getConnection();
	}

	public List<KensakuBean> findAll() throws DAOException {
		if (con == null) 
			getConnection();
		
			PreparedStatement st = null;
			ResultSet rs = null;
			// 商品名と価格をとる
			try {
				String sql = "SELECT * FROM product";
				st = con.prepareStatement(sql);
				rs = st.executeQuery();
				List<KensakuBean> list = new ArrayList<KensakuBean>();
				while (rs.next()) {
					String title2 = rs.getString("title");
					int price2 = rs.getInt("price");
					KensakuBean bean = new KensakuBean(title2, price2);
					list.add(bean);
				}
				// git変更テスト
				return list;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new DAOException("error");
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (st != null)
						st.close();
					close();
				} catch (Exception e) {
					// TODO: handle exception
					throw new DAOException("error2");
				}
			}
		}


	public List<KensakuBean> searchBook(String title, String author, String publisher, String category,
			String recommend) throws DAOException {
		if (con == null) 
			getConnection();

			PreparedStatement st = null;
			ResultSet rs = null;
			try {
				String sql = "SELECT * FROM product WHERE title LIKE'title', author LIKE'author', publisher LIKE 'publisher', category, recommend FROM product";
				st = con.prepareStatement(sql);
				rs = st.executeQuery();
				List<KensakuBean> list = new ArrayList<KensakuBean>();
				while (rs.next()) {
					String title2 = rs.getString("title");
					int price2 = rs.getInt("price");
					KensakuBean bean = new KensakuBean(title2,price2);
					list.add(bean);
				}
				return list;

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new DAOException("error");
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (st != null)
						st.close();
					close();
				} catch (Exception e) {
					// TODO: handle exception
					throw new DAOException("error2");
				}
			}
		}

	private void getConnection() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql:isko";
			String user = "student";
			String pass = "himitu";
			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			// TODO: handle exception
			throw new DAOException("error3");
		}
	}

	private void close() throws SQLException {
		if (con != null) {
			con.close();
			con = null;

		}
	}

}
