package com.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data.DataBase;


@WebServlet("/UserRegister")
/**
 * Servlet implementation class UserRegistration
 */
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String phno=request.getParameter("phno");
		String adhaar=request.getParameter("adhaar");

		HashMap<String,String> user=new HashMap<>();
		user.put("email", email);
		user.put("password", password);
		user.put("name", name);
		user.put("phno", phno);
		user.put("adhaar", adhaar);

		
		Properties props=new Properties();
		props.load(getServletContext().getResourceAsStream("/WEB-INF/application.properties"));
		try {
			DataBase data =new DataBase(props.getProperty("driver"),props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
			
//			Connection conn= data.getConnection();
//			
//			PreparedStatement stmt= conn.prepareStatement("insert into user (email=?, password=?, name=?, phno=?, adhaar=?)");
//			stmt.setString(1, email);
//			stmt.setString(2, password);
//			stmt.setString(3, name);
//			stmt.setString(4, phno);
//			stmt.setString(5, adhaar);

			boolean text=data.insertUser(user);
			HttpSession session=request.getSession();
			if(text) {
				session.setAttribute("message", "User Added Successfully");
			}
			else {
				session.setAttribute("error","Invalid Details");
			}
		
		response.sendRedirect("UserPage.jsp");
	
	}catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}	
	}
}