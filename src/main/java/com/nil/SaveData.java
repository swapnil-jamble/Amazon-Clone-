package com.nil;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SaveData extends HttpServlet{
 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		String name = req.getParameter("name");
		String phEmail = req.getParameter("phoneEmail");
		String password = req.getParameter("password");
		
		HttpSession session = req.getSession();
		session.setAttribute("name", name);
		session.setAttribute("email", phEmail);
		session.setAttribute("password", password);
		
		Customer customer = new Customer();
		customer.setName(name);
		customer.setPhoneEmail(phEmail);
		customer.setPassword(password);
		
		et.begin();
		em.persist(customer);
		et.commit();
		
		RequestDispatcher rd = req.getRequestDispatcher("profile.jsp");
		rd.include(req, resp);
	}
}
