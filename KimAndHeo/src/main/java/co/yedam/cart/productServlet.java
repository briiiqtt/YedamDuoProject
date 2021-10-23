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

@WebServlet("/productServlet")
public class productServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public productServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8") ;
		response.setCharacterEncoding("UTF-8") ;
		response.setContentType("text/html; charset=UTF-8") ;
		
		PrintWriter out = response.getWriter() ;
		String cmd = request.getParameter("cmd") ;
		ProductDAO dao = new ProductDAO() ;
		Gson gson = new GsonBuilder().create() ;
		
		
		//cmd = "list" ;
		if (cmd.equals("list")) { // 혹시 add 추가할까봐 만들어놓은것 . 목록을 보여줄지, 추가를 할지 변수를 받는곳
			//String id = "1" ; // 데이터베이스에서 자료를 불러올 id 를 변수로 받는곳
			String id = request.getParameter("productID");
			List<Product> list = dao.getProductList(id) ;
			out.println(gson.toJson(list)) ;
			
		} else if (cmd.equals("listAll")) {
			List<Product> list = dao.getProductListAll() ;
			out.println(gson.toJson(list)) ;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
