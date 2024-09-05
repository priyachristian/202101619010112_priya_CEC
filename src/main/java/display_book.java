

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class display_book
 */
@WebServlet("/display_book")
public class display_book extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public display_book() {
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
			
			PreparedStatement p=con.prepareStatement("SELECT * FROM book");
			
			ResultSet r=p.executeQuery();
			
			out.println("<h1>All Books</h1>");
			while(r.next())
			{
				int bid=r.getInt(1);
				bname=r.getString(2);
				bprice=r.getString(3);
				aname=r.getString(4);
				
				String LinkURL= "book_details?bid="+bid+"&bname="+bname+"&bprice="+bprice+"&aname="+aname;
				out.println("<a href='"+LinkURL+"'>"+bname+"</a><br><br>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
