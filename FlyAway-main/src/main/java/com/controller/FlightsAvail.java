package com.controller;

import java.io.IOException;


import java.sql.SQLException;
import java.util.List;
import java.util.Properties;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data.DataBase;

@WebServlet("/FlightsAvail")
/**
 * Servlet implementation class FlightList
 */
public class FlightsAvail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		Properties props=new Properties();
		props.load(getServletContext().getResourceAsStream("/WEB-INF/application.properties"));
		try {
			DataBase data =new DataBase(props.getProperty("driver"),props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
			
//			Connection conn= data.getConnection();
			
//			PreparedStatement stmt= conn.prepareStatement("source=?, destination=?");
//			stmt.setString(1, source);
//			stmt.setString(2, destination);
			
		List <String[]> flights=data.getAvailableFlights(source, destination);			
		HttpSession session=request.getSession();
		session.setAttribute("flights", flights);
		response.sendRedirect("FlightList.jsp");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}