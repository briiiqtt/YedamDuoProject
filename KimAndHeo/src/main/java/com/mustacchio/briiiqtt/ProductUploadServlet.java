package com.mustacchio.briiiqtt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yedam.cart.Product;

@WebServlet("/ProductUploadServlet")
public class ProductUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductUploadServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charSet=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		ServletContext context = getServletContext();
		String saveDir = context.getRealPath("img2");
		int maxSize = 1024 * 1024 * 30;
		String encoding = "utf-8";
		MultipartRequest multi = //
				new MultipartRequest(request, saveDir, maxSize//
						, encoding, new DefaultFileRenamePolicy());

		String name = multi.getParameter("productName");
		String brand = multi.getParameter("brand");
		int offPrice = Integer.parseInt(multi.getParameter("offprice"));
		int originPrice = Integer.parseInt(multi.getParameter("originprice"));
		String file = multi.getFilesystemName("file");

		Product product = new Product();
		product.setName(name);
		product.setOffprice(offPrice);
		product.setOriginprice(originPrice);
		product.setBrand(brand);
		product.setFilename(file);
		ProductUploadDAO dao = new ProductUploadDAO();
		int r = dao.uploadProduct(product);

		if (r > 0) {
			System.out.println(r + "행 추가");
			out.println(r);
			System.out.println(saveDir);
		} else if (r < 0) {
			System.out.println(r + " (SQL에러)");
			out.println(r);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
