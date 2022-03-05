package com.controller;


import java.io.IOException;

import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data.DataBase;


@WebServlet("/ForgotPassword")
/**
 * Servlet implementation class ForgotPassword
 */
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String password=request.getParameter("password");

		Properties props=new Properties();
		props.load(getServletContext().getResourceAsStream("/WEB-INF/application.properties"));
		try {
			DataBase data =new DataBase(props.getProperty("driver"),props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
			
			HttpSession session=request.getSession();
			if(data.changeAdminPassword(email,password)) {
				session.setAttribute("text", "Password Changed Successfully");
			}
			else {
				session.setAttribute("Error", "Invalid Details");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("Admin.jsp");
	}

}