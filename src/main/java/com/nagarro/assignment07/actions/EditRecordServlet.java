package com.nagarro.assignment07.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nagarro.assignment07.productmanagement.*;

@WebServlet("/EditRecord")
public class EditRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from ProductDetails where title=:title");
		query.setParameter("title", title);

		@SuppressWarnings("unused")
		ProductDetails user = (ProductDetails) query.uniqueResult();

		String productIdString = request.getParameter("id");
		int productId = Integer.parseInt(productIdString);
		ProductDetails productDetails = session.get(ProductDetails.class, productId);

		request.setAttribute("productDetails", productDetails);
		request.getRequestDispatcher("ProductManagement.jsp").forward(request, response);

//		update.setTitle(request.getParameter("title"));
//		update.setQuantity(Integer.parseInt(request.getParameter("quantity")));
//		update.setSize(Integer.parseInt(request.getParameter("size")));
//		update.setImage(request.getParameter("image"));

//		session.update(update);
		tx.commit();
		session.close();
		response.sendRedirect("ProductManagement.jsp");

	}
}
