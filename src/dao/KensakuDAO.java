package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.KensakuBean;
import dao.DAOException;

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
					int code2 = rs.getInt("code");
					String title2 = rs.getString("title");
					int price2 = rs.getInt("price");
					KensakuBean bean = new KensakuBean(code2, title2, price2);
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
			//test
			try {
				String sql = "SELECT * FROM product WHERE title LIKE ? AND author LIKE ? AND publisher LIKE ? AND category LIKE ? AND recommended LIKE ?";
				String queryConditionTitle = "%" + title + "%";
				String queryConditionAuthor = "%" + author + "%";
				String queryConditionPublisher = "%" + publisher + "%";
				String queryConditionCategory = "%" + category + "%";
				String queryConditionRecommend = "%" + recommend + "%";
				st = con.prepareStatement(sql);
				st.setString(1, queryConditionTitle);
				st.setString(2, queryConditionAuthor);
				st.setString(3, queryConditionPublisher);
				st.setString(4, queryConditionCategory);
				st.setString(5, queryConditionRecommend);
				rs = st.executeQuery();
				List<KensakuBean> list = new ArrayList<KensakuBean>();
				while (rs.next()) {
					int code2 = rs.getInt("code");
					String title2 = rs.getString("title");
					int price2 = rs.getInt("price");
					KensakuBean bean = new KensakuBean(code2, title2,price2);
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
	//商品一覧から商品詳細へ渡す
	public List<KensakuBean> resultAll(int item_code2) throws DAOException {
		if (con == null) 
			getConnection();

			PreparedStatement st = null;
			ResultSet rs = null;
			try {
				String sql = "SELECT*FROM product WHERE code=?";
				st = con.prepareStatement(sql);
				st.setInt(1, item_code2);
				rs = st.executeQuery();
				List<KensakuBean> list = new ArrayList<KensakuBean>();
				while (rs.next()) {
					String title = rs.getString("title");
					int price = rs.getInt("price");
					String author=rs.getString("author");
					String publisher=rs.getString("publisher");
					String category=rs.getString("category");
					String recommend=rs.getString("recommended");
					KensakuBean bean = new KensakuBean(title,price,author,publisher,category,recommend);
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
