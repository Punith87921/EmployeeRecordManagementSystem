

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmployee extends HttpServlet {
	Connection con = null;
	PreparedStatement ps = null;
//	ResultSet rs = null;
	PrintWriter pw = null;
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/employee";
	String username = "root";
	String password = "Punigowda@86";
	String sql = "insert into employeedata values(?,?,?,?,?)";

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
			String ename = req.getParameter("en");
			String age = req.getParameter("ea");
			int eage = Integer.parseInt(age);
			String edepart = req.getParameter("ed");
			String salary = req.getParameter("es");
			int esalary = Integer.parseInt(salary);
			
			ps.setInt(1, eid);
			ps.setString(2, ename);
			ps.setInt(3, eage);
			ps.setString(4, edepart);
			ps.setInt(5, esalary);
			
			int nora = ps.executeUpdate();
if (nora == 1) {
	pw.println("<!DOCTYPE html><html><head><style>");
	pw.println("body {font-family: Arial, sans-serif; text-align: center; margin-top: 50px;}");
	pw.println("p {color: #333; font-size: 24px;}");
	pw.println("ul {list-style-type: none; font-size: 18px; font-weight: bold;}");
	pw.println("a {font-size: 18px; color: #007bff; text-decoration: none;}");
	pw.println("a:hover {text-decoration: underline;}");
	pw.println("</style></head><body><center>");
	pw.println("<p>Employee with ID: <strong>"+eid+"</strong> is added successfully.</p>");
	pw.println("<a href='http://localhost:9090/EmployeeRecordManagementSystem/first.html'>Click here to <strong>Main page</strong></a>");
	pw.println("</center></body></html>");

}  else {
	pw.println("<!DOCTYPE html><html><head><style>");
	pw.println("body {font-family: Arial, sans-serif; text-align: center; margin-top: 50px;}");
	pw.println("h3 {color: #f44336; font-size: 24px;}");
	pw.println("a {font-size: 18px; color: #007bff; text-decoration: none;}");
	pw.println("a:hover {text-decoration: underline;}");
	pw.println("</style></head><body><center>");
	pw.println("<h3>Oops, something went wrong. Please try again....</h3>");
	pw.println("<a href='http://localhost:9090/EmployeeRecordManagementSystem/first.html'>Click here to <strong>Main page</strong></a>");
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
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
