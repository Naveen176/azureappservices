package com.nagarro.assignment07.insertdata;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nagarro.assignment07.productmanagement.ProductDetails;

@WebServlet("/insertData")
public class InsertDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertDataServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int size = Integer.parseInt(request.getParameter("size"));
		String image = request.getParameter("image");

		if (title.length() != 0 && quantity != 0 && size != 0 && image.length() != 0) {

			ProductDetails userData = new ProductDetails();
			userData.setTitle(title);
			userData.setQuantity(quantity);
			userData.setSize(size);
			userData.setImage(image);

			Configuration con = new Configuration().configure().addAnnotatedClass(ProductDetails.class);

			SessionFactory sf = con.buildSessionFactory();

			Session session = sf.openSession();

			Transaction tx = session.beginTransaction();

			session.saveOrUpdate(userData);

			tx.commit();

			session.close();
		}
		response.sendRedirect("ProductManagement.jsp");
	}

}
