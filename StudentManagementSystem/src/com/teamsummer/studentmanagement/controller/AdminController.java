package com.teamsummer.studentmanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentmanagement.dbconnection.DBconnection;

/**
 * Servlet implementation class AdminController
 */

public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Statement stmt = null;
		ResultSet result = null;

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		 //declaring the variables
		String adminid = request.getParameter("adminid");
		String adminpassword = request.getParameter("adminpassword");
		
		
		try {
			 //creating object for DBconnection
			DBconnection dbconnection = new DBconnection();
			
			// load the driver
			dbconnection.loadDriver();
			
			//establishing the connection
			Connection connection = DBconnection.getConnection();
			
			//creating statement
			stmt = connection.createStatement();
			
			// executing the query
			result = stmt.executeQuery("select * from student_data");
		
			
			writer.println("<center>");

			//condition for checking admin id and admin password
			if (adminid.equals("admin") && adminpassword.equals("admin123")) {
				
				writer.println("<h1>Total student details</h1>");
				
				//printing column names
				writer.println(
						"<table border ='1'>"
						+ "<tr>"
						+ "<td>Roll No</td>"
						+ "<td>Student Name</td>"
						+ "<td>Attendance</td>"
						+ "<td>Physics</td>"
						+ "<td>Chemistry</td>"
						+ "<td>English</td>"
						+ "<td>Mathematics</td>"
						+ "<td>Overall GPA</td>"
						+ "<td>Class Awarded</td>"
						+ "<td>Remarks</td></tr>");
				
				
				while(result.next()) {
					
					//printing data of corresponding column names
					
					writer.println
				            	( "<tr>" 
							    + "<td>" + result.getInt(1) + "</td>"
								 + "<td>" + result.getString(3) + "</td>"
								 + "<td>" + result.getInt(4) + "</td>"
								 + "<td>" + result.getFloat(5) +"</td>"
								 + "<td>" + result.getFloat(6) +"</td>"
								 + "<td>" + result.getFloat(7) + "</td>"
								 + "<td>" + result.getFloat(8) + "</td>"
								 + "<td>" + result.getFloat(9) + "</td>"
								 + "<td>" + result.getString(10) + "</td>"
								 + "<td>" + result.getString(11) + "</td>"
								 + "</tr>");
				

				}
				writer.println("</table>");
			}
			
			//for invalid credentials
			else {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminview.jsp");
				dispatcher.include(request, response);
				writer.println("<font color = red>Invalid credentials, Please enter the correct details</font>");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	}
