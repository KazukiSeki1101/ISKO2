package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.KensakuBean;
import hinan.DAOException;
import hinan.KensakuDAO;

import java.util.List;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");

			KensakuDAO dao = new KensakuDAO();
			// 検索内容未入力の場合は全表示
			if (action == null || action.length() == 0) {
				List<KensakuBean> list = dao.findAll();
				request.setAttribute("items", list);
				gotoPage(request, response, "/result.jsp");

				// 検索したい内容をdao.searchbookへ送る
			} else if (action.equals("search")) {
				String title = request.getParameter("title");
				String author = request.getParameter("author");
				String publisher = request.getParameter("publisher");
				String category = request.getParameter("category");
				String recommend = request.getParameter("recommend");

				dao.searchBook(title, author, publisher, category, recommend);

				List<KensakuBean> list = dao.searchBook(title, author, publisher, category, recommend);
				request.setAttribute("items", list);
				gotoPage(request, response, "/result.jsp");
			}

		} catch (DAOException e) {
			// TODO: handle exception
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
