package co.yedam.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/cartServlet")
public class cartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public cartServlet() {
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8") ;
		response.setCharacterEncoding("UTF-8") ;
		response.setContentType("text/html; charset=UTF-8") ;
		
		PrintWriter out = response.getWriter() ;
		String cmd = request.getParameter("cmd") ;
		CartDAO dao = new CartDAO() ;
		Gson gson = new GsonBuilder().create() ;
		
		if (cmd.equals("list")) {
			List<Cart> list = dao.getCartList() ;
			out.println(gson.toJson(list)) ;
			
		} else if (cmd.equals("add")) {
			String id = request.getParameter("id") ;
			String name = request.getParameter("name") ;
			String price = request.getParameter("price") ;
			String psize = request.getParameter("psize") ;
			String count = request.getParameter("count") ;
			String delivery = request.getParameter("deliveryfee") ;
			String img = request.getParameter("img") ;
			
			Cart cart = new Cart() ;
			cart.setId(id) ;
			cart.setName(name) ;
			cart.setPrice(Integer.parseInt(price)) ;
			cart.setPsize(psize) ;
			cart.setCount(Integer.parseInt(count)) ;
			cart.setDeliveryfee(Integer.parseInt(delivery)) ;
			cart.setImg(img) ;
			
			dao.insertCart(cart) ;
			
			out.println(gson.toJson(cart)) ;	
		} else if (cmd.equals("final")) {
			List<Cart> list = dao.finalprice() ;
			out.println(gson.toJson(list)) ;
		} else if (cmd.equals("buy")) {
			dao.buyCart() ;
		} else if (cmd.equals("del")) {
			String id = request.getParameter("id") ;
			if(dao.deleteCart(id) == null) {
				out.println("{\"retCode\":\"fail\"}") ;
				return ;
			}
			out.println("{\"retCode\":\"success\"}") ;
		} else {
			out.println("<h1>" + cmd + "</h1>") ;
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
