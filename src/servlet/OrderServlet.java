package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CartBean;


/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		//注文処理業務はセッションとCartが存在することが前提
		HttpSession session = request.getSession(false);
		if(session == null) { //セッションオブジェクトなし
			request.setAttribute("message",
					"セッションが切れています。もう一度トップページより操作してください。");
			gotoPage(request,response,"errInternal.jsp");
			return;
		}
		
		@SuppressWarnings("unchecked")
		List<CartBean> cart = (List<CartBean>)session.getAttribute("cart");
		
		if(cart == null) { //カートがない
			request.setAttribute("message","正しく操作してください。");
			gotoPage(request,response,"errInternal.jsp");
			return;
		}

		//パラメータ解析
		String action = request.getParameter("action");

		if(action == null || action.length() == 0) {
			request.setAttribute("message","正しく操作してください。");
			gotoPage(request,response,"errInternal.jsp");
		} else if(action.equals("order")) {
			session.setAttribute("cart", cart);
			gotoPage(request, response, "/order.jsp");
		} else if(action.equals("end")) {
			session.setAttribute("cart", cart);
			gotoPage(request, response, "/buy.jsp");
		} else { //actionの値が不正
			request.setAttribute("messege","正しく操作してください。");
			gotoPage(request,response,"errInternal.jsp");
		}
	}

	private void gotoPage(HttpServletRequest request,HttpServletResponse response,String page)throws ServletException,IOException{
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}