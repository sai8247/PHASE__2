package com.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class DataBase {

	private Connection connection;
	private Statement stmt;
	

	public DataBase(String driver, String url, String user, String pwd) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		this.connection = DriverManager.getConnection(url, user, pwd);
	}

	public Connection getConnection() {
		return connection;
	}

	public void closeConnection() throws SQLException {
		this.connection.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		Properties props = new Properties();
		props.load(getServletContext().getResourceAsStream("/WEB-INF/application.properties"));

	}

	@SuppressWarnings("rawtypes")
	private Class getServletContext() {

		return null;
	}

	public List<String[]> getAvailableFlights(String source, String destination) {

		List<String[]> flights = new ArrayList<>();
		String query = "SELECT * from flights where source=" + source + "and Destination " + destination;
		try {
			
			stmt=connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				String[] flight = new String[2];
				flight[0] = rs.getString("source");
				flight[1] = rs.getString("destination");

				flights.add(flight);
				return flights;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public HashMap<String, String> checkUser(String email, String password) {

		HashMap<String, String> user = null;
		String query = "select * from user where email='" + email + "' and password='" + password + "'";
		try {
			stmt=connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				user = new HashMap<>();
				user.put("name", rs.getString("name"));
				user.put("email", rs.getString("email"));
				user.put("phno", rs.getString("phno"));
				user.put("adno", rs.getString("adno"));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public boolean insertUser(HashMap<String, String> user) {

		String query = "INSERT INTO user (email, password, name, phno, adhaar) values('" + user.get("email") + "','"
				+ user.get("password") + "','" + user.get("name") + "','" + user.get("phno") + "','" + user.get("adhaar")
				+ "')";

		try {
			stmt=connection.createStatement();
			stmt.execute(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkAdmin(String email, String password) {

		try {
			stmt=connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from admin where email='" + email + "' and password='" + password + "'");
			if (rs.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean changeAdminPassword(String email, String password) {

		try {
			stmt=connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from admin where email='" + email + "'");
			if (!rs.next()) {
				return false;
			}
			stmt.execute("set admin password='" + password + "' where email='" + email + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}