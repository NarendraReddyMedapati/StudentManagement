package com.teamsummer.studentmanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentmanagement.dbconnection.DBconnection;


public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public StudentController() {
		super();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean status = true;

		PreparedStatement pstmt = null;
		ResultSet result = null;

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
       //declaring the variables
		String number =request.getParameter("rollnumber");
		String password = request.getParameter("studentpassword");
		
		try {
			
            //creating object for DBconnection
			DBconnection dbconnection = new DBconnection();
			
		   // load the driver
			dbconnection.loadDriver();
			
			//establishing the connection
			Connection connection = DBconnection.getConnection();
			
			//creating the statement
			pstmt = connection.prepareStatement("select * from  student_data where Roll_No = ? and Student_Password = ?");
			
			//passing parameters
			pstmt.setString(1, number); 
			pstmt.setString(2, password);
			
			// executing the query
			result = pstmt.executeQuery(); 

			writer.println("<center>");
			status = result.next();

			if (status == true) {

				writer.println("<h1>Student Result</h1>");
				
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
				
				//printing data of corresponding column names
				writer.println
				("<tr>"
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
				+ "</tr></table>");
             
			} 
			//for invalid credentials
			else {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("studentview.jsp");
				dispatcher.include(request, response);
				writer.println("<font color=red>Invalid credentials, Please enter the correct details</font>");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
