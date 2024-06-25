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

public class SaveProfile extends HttpServlet{
 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		long phoneno = Long.parseLong(req.getParameter("phoneno"));
		String city = req.getParameter("city");
		int pincode = Integer.parseInt(req.getParameter("pincode"));
		
		
		
		Profile profile = new Profile();
		profile.setName(name);
		profile.setEmail(email);
		profile.setPhonenno(phoneno);
		profile.setCity(city);
		profile.setPincode(pincode);
		
		et.begin();
		em.persist(profile);
		et.commit();
		
		RequestDispatcher rd = req.getRequestDispatcher("index.html");
		rd.include(req, resp);
	}
}
