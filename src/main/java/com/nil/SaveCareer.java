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

public class SaveCareer extends HttpServlet{
 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		String email = req.getParameter("email");
		String position = req.getParameter("position");
		String skills = req.getParameter("skills");
		
		Career career = new Career();
		career.setEmail(email);
		career.setPosition(position);
		career.setSkills(skills);
		
		et.begin();
		em.persist(career);
		et.commit();
		
		RequestDispatcher rd = req.getRequestDispatcher("index.html");
		rd.include(req, resp);
	}
}
