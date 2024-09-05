

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String contact=request.getParameter("contact");
		String email=request.getParameter("email");
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gls", "root", "priya7504");
			
			PreparedStatement p=con.prepareStatement("INSERT INTO register(username, password, fname, lname, contact, email) VALUES(?, ?, ?, ?, ?, ?)");
			p.setString(1, username);
			p.setString(2, password);
			p.setString(3, fname);
			p.setString(4, lname);
			p.setString(5, contact);
			p.setString(6, email);
			
			p.executeUpdate();
			
			out.println("<h1>Register Successfully..!!</h1>");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
