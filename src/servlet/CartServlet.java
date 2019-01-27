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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");	
		// パラメータの解析
			String action = request.getParameter("action");
			String title = request.getParameter("title");
			String price = request.getParameter("price");
			String quantity = request.getParameter("quantity");
			String code = request.getParameter("code");

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
				int totalprice = 0;
				for(CartBean cartbean : cart){
					totalprice += cartbean.getPrice();
				}
				session.setAttribute("cart", cart);
				session.setAttribute("totalprice", totalprice);
				gotoPage(request, response, "/cart.jsp");
			} else if(action.equals("delete")) {
				String index_number = request.getParameter("index_number");
				HttpSession session = request.getSession(false);
				@SuppressWarnings("unchecked")
				List<CartBean> cart = (List<CartBean>)session.getAttribute("cart");
				cart.remove(Integer.parseInt(index_number));
				int totalprice = 0;
				for(CartBean cartbean : cart){
					totalprice += cartbean.getPrice();
				}
				session.setAttribute("cart", cart);
				session.setAttribute("totalprice", totalprice);
				gotoPage(request, response, "/cart.jsp");
			} else if(action.equals("update")) {
				String index_number = request.getParameter("index_number");
				HttpSession session = request.getSession(false);

				@SuppressWarnings("unchecked")
				List<CartBean> cart = (List<CartBean>)session.getAttribute("cart");
				CartBean updatebean = cart.get(Integer.parseInt(index_number));
				updatebean.setQuantity(Integer.parseInt(quantity));
				cart.set(Integer.parseInt(index_number), updatebean);
				int totalprice = 0;
				
				for(CartBean cartbean : cart){
					totalprice += cartbean.getPrice() * cartbean.getQuantity();
				}
				session.setAttribute("cart", cart);
				session.setAttribute("totalprice", totalprice);
				gotoPage(request, response, "/cart.jsp");
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