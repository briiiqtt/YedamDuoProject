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

@WebServlet("/EpilogueServlet")
public class EpilogueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EpilogueServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8") ;
		response.setCharacterEncoding("UTF-8") ;
		response.setContentType("text/html; charset=UTF-8") ;
		
		PrintWriter out = response.getWriter() ;
		String cmd = request.getParameter("cmd") ;
		EpilogueDAO dao = new EpilogueDAO() ;
		Gson gson = new GsonBuilder().create() ;
		
		if(cmd.equals("list")) {
			List<Epilogue> list = dao.getEpilogue() ;
			out.println(gson.toJson(list)) ;
		} else if (cmd.equals("add")) {
			String id = request.getParameter("id") ;
			String name = request.getParameter("name") ;
			String content = request.getParameter("content") ;
			
			Epilogue epilogue = new Epilogue() ;
			epilogue.setId(id) ;
			epilogue.setName(name) ;
			epilogue.setContent(content) ;
			
			dao.insertEpilogue(epilogue) ;
			
			out.println(gson.toJson(epilogue)) ;
		} else if (cmd.equals("mod")) {
			String id = request.getParameter("id") ;
			String content = request.getParameter("content") ;
			
			Epilogue epilogue = new Epilogue() ;
			epilogue.setId(id) ;
			epilogue.setContent(content) ;
			
			dao.updateEpilogue(epilogue) ;
			out.println(gson.toJson(epilogue)) ;
		} else if (cmd.equals("del")) {
			String id = request.getParameter("id") ;
			if(dao.deleteEpilogue(id) == null) {
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
