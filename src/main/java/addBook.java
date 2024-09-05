

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
 * Servlet implementation class addBook
 */
@WebServlet("/addBook")
public class addBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String bname=request.getParameter("bname");
		String bprice=request.getParameter("bprice");
		String aname=request.getParameter("aname");
	
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gls", "root", "priya7504");
			
			PreparedStatement p=con.prepareStatement("INSERT INTO book(bname, bprice, aname) VALUES(?, ?, ?)");
			p.setString(1, bname);
			p.setString(2, bprice);
			p.setString(3, aname);
			
			p.executeUpdate();
			
			out.println("<h1>Book Added Successfully..!!</h1>");
			out.println("<a href=\"display_book\">Show Book</a>");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
