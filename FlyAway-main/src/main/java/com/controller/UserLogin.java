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

@WebServlet("/UserLogin")
/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");

		Properties props=new Properties();
		props.load(getServletContext().getResourceAsStream("/WEB-INF/application.properties"));
		try {
			DataBase data =new DataBase(props.getProperty("driver"),props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
			
////			Connection conn= data.getConnection();
//			
//			PreparedStatement stmt= conn.prepareStatement("email=?, password=?");
//			stmt.setString(1, email);
//			stmt.setString(2, password);

			HashMap<String,String> user=data.checkUser(email,password);
			HttpSession session=request.getSession();
			if(user!=null) {
				session.setAttribute("user", user);
				response.sendRedirect("HomePage.jsp");
			}
			else {
				session.setAttribute("error", "Invalid Details");
				response.sendRedirect("UserPage.jsp");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	
	}
	

}
