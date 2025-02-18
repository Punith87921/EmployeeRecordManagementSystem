

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateEmployee extends HttpServlet {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	PrintWriter pw = null;
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/employee";
	String username = "root";
	String password = "Punigowda@86";
	String sql = "Select * from employeedata where id=?";

	public void init() {
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url,username,password);
			ps=con.prepareStatement(sql);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void service(HttpServletRequest req, HttpServletResponse res) {
		try {
			pw = res.getWriter();
			String id = req.getParameter("eid");
			int eid = Integer.parseInt(id);
			
			ps.setInt(1, eid);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				res.sendRedirect("http://localhost:9090/EmployeeRecordManagementSystem/FinalUpdate.html");
			} else {
				pw.println("<!DOCTYPE html><html><head><style>");
				pw.println("body {font-family: Arial, sans-serif; text-align: center; margin-top: 50px;}");
				pw.println("h3 {color: #f44336; font-size: 24px;}");
				pw.println("a {font-size: 18px; color: #007bff; text-decoration: none;}");
				pw.println("a:hover {text-decoration: underline;}");
				pw.println("</style></head><body><center>");
				pw.println("<h3>Invalid ID, Please enter valid ID.</h3>");
				pw.println("<a href='http://localhost:9090/EmployeeRecordManagementSystem/update.html'>Click here to <strong>Update page</strong></a>");
				pw.println("</center></body></html>");

			}
	}
catch (Exception e) {
	e.printStackTrace();
}
}
	public void destroy() {
		try {
			ps.close();
			con.close();
			rs.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
