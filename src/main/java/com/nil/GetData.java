package com.nil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetData extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		Customer customer = null;
		PrintWriter pw = resp.getWriter();
		
		String phEmail = req.getParameter("phoneEmail");
		String password = req.getParameter("password");
		RequestDispatcher rd = null;
		
		try {
			customer = em.find(Customer.class, phEmail);
			String dbEmail = customer.getPhoneEmail();
			String dbPassword = customer.getPassword();
			
			
			if(customer!=null) {
				if(dbEmail.equals(phEmail) && dbPassword.equals(password)) {
				       System.out.println("login successfully");
				       rd = req.getRequestDispatcher("index.html");
						 rd.include(req, resp);
		                 pw.println("<script>document.getElementById('jsText').innerHTML = 'Hello, Swapnil';</script>");
		                 
		       
				}
				else {
					 rd = req.getRequestDispatcher("login.html");
					 rd.include(req, resp);
	                 pw.println("<script>document.getElementById('error-message').innerHTML = 'Wrong Password';</script>");
					System.out.println("login failed");
				}
			}
			else {
				System.out.println("login failed");
			}
		}
		catch(Exception e) {
			rd = req.getRequestDispatcher("login.html");
			 rd.include(req, resp);
             pw.println("<script>document.getElementById('error-message').innerHTML = 'Wrong Email Id Or Phone number';</script>");
			System.out.println("Wrong Emailid!!!");
		}
		
		
		
		
	}

}
