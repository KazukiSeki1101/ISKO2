package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CartBean;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "unlikely-arg-type", "unused" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		// パラメータの解析
			String action = request.getParameter("action");
			String title = request.getParameter("title");
			String price = request.getParameter("price");
			String quantity = request.getParameter("quantity");
			String code = request.getParameter("code");
			String index = request.getParameter("index");
			
			// showまたはパラメータなしの場合はカートページを表示
			if (action == null || action.length() == 0 || action.equals("show")) {
				gotoPage(request, response, "/cart.jsp");
				// addはカートに追加処理
			} else if (action.equals("add")) {
				HttpSession session = request.getSession(true);
				CartBean bean = new CartBean(title, Integer.parseInt(price), Integer.parseInt(quantity), Integer.parseInt(code));
				
				@SuppressWarnings("unchecked")
				List<CartBean> cart = (List<CartBean>)session.getAttribute("cart");
				
				if (cart == null) { // 初めてのクライアントの場合はカートを作成する
					cart = new ArrayList<CartBean>();
				}
				cart.add(bean);
				
				session.setAttribute("cart", cart);
				gotoPage(request, response, "/cart.jsp");
			} else if(action.equals("delete")) {
				HttpSession session = request.getSession(true);
				CartBean bean = new CartBean(title, Integer.parseInt(price), Integer.parseInt(quantity), Integer.parseInt(code));
				@SuppressWarnings("unchecked")
				List<CartBean> cart = (List<CartBean>)session.getAttribute("cart");
				
				if (cart == null) { // 初めてのクライアントの場合はカートを作成する
					cart = new ArrayList<CartBean>();					
				}
				cart.remove(index);
				
			} else { //actionの値が不正
				request.setAttribute("message", "正しく操作してください。");
				gotoPage(request, response, "/errInternal.jsp");
				return;
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	private void gotoPage(HttpServletRequest request,HttpServletResponse response,String page)throws ServletException,IOException{
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}