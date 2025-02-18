

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ViewEmploye extends HttpServlet {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	PrintWriter pw = null;
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/employee";
	String username = "root";
	String password = "Punigowda@86";
	String sql = "select * from employeedata where id=?";

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
	pw.println("<!DOCTYPE html><html><head><style>");
	pw.println("body {font-family: Arial, sans-serif; text-align: center; margin-top: 50px;}");
	pw.println("table {width: 70%; margin: 20px auto; border-collapse: collapse;}");
	pw.println("th, td {padding: 10px; border: 1px solid #ddd; text-align: left;}");
	pw.println("th {background-color: #f2f2f2;}");
	pw.println("a {font-size: 18px; color: #007bff; text-decoration: none;}");
	pw.println("a:hover {text-decoration: underline;}");
	pw.println("</style></head><body><center><h3>Employee Data:</h3>");
	pw.println("<table>");
	pw.println("<tr><th>Id</th><th>Name</th><th>Age</th><th>Department</th><th>Salary</th></tr>");
	pw.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getInt(5)+"</td></tr>");
	pw.println("</table><br><br>");
	pw.println("<a href='http://localhost:9090/EmployeeRecordManagementSystem/first.html'>click here for <strong>Main page</strong></a>");
	pw.println("</center></body></html>");

} else {
	pw.println("<!DOCTYPE html><html><head><style>");
	pw.println("body {font-family: Arial, sans-serif; text-align: center; margin-top: 50px;}");
	pw.println("h2 {color: #f44336; font-size: 24px;}");
	pw.println("a {font-size: 18px; color: #007bff; text-decoration: none;}");
	pw.println("a:hover {text-decoration: underline;}");
	pw.println("</style></head><body><center>");
	pw.println("<h2>Invalid ID, Please try again....</h2>");
	pw.println("<a href='http://localhost:9090/EmployeeRecordManagementSystem/view.html'>Click here to <strong>View Employee Data</strong></a>");
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
