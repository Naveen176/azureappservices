package com.nagarro.assignment07.actions;

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
import org.hibernate.query.Query;

import com.nagarro.assignment07.productmanagement.*;

@WebServlet("/DeleteRecord")
public class DeleteRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		Configuration config = new Configuration().configure();
		config.addAnnotatedClass(ProductDetails.class);
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		sf = config.buildSessionFactory();
		Transaction tx = session.beginTransaction();

		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("delete from ProductDetails where title=:title");
		query.setParameter("title", title);
		@SuppressWarnings("unused")
		int rowsDeleted = query.executeUpdate();

		tx.commit();
		session.close();

		response.sendRedirect("ProductManagement.jsp");
	}
}
