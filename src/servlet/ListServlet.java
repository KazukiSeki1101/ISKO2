package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KensakuDAO;
import bean.KensakuBean;

@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = request.getParameter("action");
			KensakuDAO dao = new KensakuDAO();
			
<<<<<<< HEAD
			if (action == null || action.length() == 0 || action.equals("")) {
				gotoPage(request, response, "/detail.jsp");
			} else if (action.equals("list")) {
				List<KensakuBean> list = dao.searchBook("title","author","publisher","category","recommend");
				// Listをリクエストスコープに入れてJSPへフォーワードする
				request.setAttribute("items", list);
				gotoPage(request, response, "/detail.jsp");
=======
			if (action.equals("top") || action == null || action.length() == 0 || action.equals("")) {
				gotoPage(request, response, "top.jsp");
>>>>>>> refs/heads/master
			} else if (action.equals("detail")) {
				String item_code = request.getParameter("item_code");
<<<<<<< HEAD
				List<DetailBean> item_detail = dao.itemdetail(item_code);
=======
				List<KensakuBean> item_detail = dao.resultAll(Integer.parseInt(item_code));
				request.setAttribute("items", item_detail);
>>>>>>> refs/heads/master
				gotoPage(request, response, "/detail.jsp");
			} else {
				request.setAttribute("message", "正しく操作してください。");
				gotoPage(request, response, "/errInternal.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			gotoPage(request, response, "/errInternal.jsp");
		}
	}

	private void gotoPage(HttpServletRequest request,HttpServletResponse response, String page) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
