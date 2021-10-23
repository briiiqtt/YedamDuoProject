package com.mustacchio.briiiqtt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charSet=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String memberID = request.getParameter("memberID");
		String memberPW = request.getParameter("memberPW");
		MemberDAO dao = new MemberDAO();
		Member loggedIn = dao.login(memberID,memberPW);
		
		if (loggedIn == null) {
			System.out.println("쿼리결과 없음");
			out.println(0);
		} else {
			System.out.println(loggedIn.getMemberID()+"로 로그인");
			out.println(loggedIn.getMemberID()+"&"+loggedIn.getMemberName()+"&"+loggedIn.getMemberEMail());
			
//			Cookie IDCookie = new Cookie("memberID", loggedIn.getMemberID());
//			Cookie NameCookie = new Cookie("memberName", loggedIn.getMemberName());
//			Cookie EMailCookie = new Cookie("memberEMail", loggedIn.getMemberEMail());
//			IDCookie.setMaxAge(60*60*5);
//			NameCookie.setMaxAge(60*60*5);
//			EMailCookie.setMaxAge(60*60*5);
//			response.addCookie(IDCookie);
//			response.addCookie(NameCookie);
//			response.addCookie(EMailCookie);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
