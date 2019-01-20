package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.KensakuBean;
import dao.DAOException;
import dao.KensakuDAO;

import java.util.List;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");

			KensakuDAO dao = new KensakuDAO();
			
			if (action == null || action.length() == 0) {
				request.setAttribute("message", "表示できません");
				gotoPage(request, response, "/errInternal.jsp");
			} else if (action.equals("search")) {
				String title = request.getParameter("title");
				String author = request.getParameter("author");
				String publisher = request.getParameter("publisher");
				String category = request.getParameter("category_name");
				String recommend = request.getParameter("recommend_code");
				
				if((title == null || title.length() == 0) && (author == null || author.length() == 0) && (publisher == null || publisher.length() == 0) && (category == null || category.length() == 0) && (recommend == null || recommend.length() == 0) ){
					// 検索内容未入力の場合は全表示
					List<KensakuBean> list = dao.findAll();
					request.setAttribute("items", list);
					gotoPage(request, response, "/result.jsp");
				} else {
					// 検索したい内容をdao.searchbookへ送る
					List<KensakuBean> list = dao.searchBook(title, author, publisher, category, recommend);
					request.setAttribute("items", list);
					gotoPage(request, response, "/result.jsp");
				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			gotoPage(request, response, "/result.jsp");
		}
	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/result.jsp");
		rd.forward(request, response);
	}
	
}
