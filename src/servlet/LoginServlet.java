package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			//actionパラメータを受け取り
			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");
			
			if(action.equals("page") || action == null || action.length() == 0){
				//ログインページを表示
				gotoPage(request, response, "/LoginPage.jsp");
				
				
			} else if(action.equals("login")) {
				//ログイン認証を実施
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");			
				LoginDAO dao = new LoginDAO();
			
				if(dao.validation(id, pw)){
					HttpSession session = request.getSession(true);
					session.setAttribute("id", id);
					gotoPage(request, response, "/top.jsp");
				} else {
					request.setAttribute("message", "ログインに失敗しました");
					gotoPage(request, response, "/errInternal.jsp");
				}
			} else if(action.equals("logout")) {
				HttpSession session = request.getSession(false);
				if(session!=null) {
				session.invalidate();
				request.setAttribute("message", "ログアウトしました");
				gotoPage(request, response, "/top.jsp");
				}
			}else {
				//エラー（actionの値が不正）
				request.setAttribute("message", "正しく操作してください");
				gotoPage(request, response, "/errInternal.jsp");
			}		
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました");
			gotoPage(request, response, "/errInternal.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
}
