

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
 * Servlet implementation class display_book_details
 */
@WebServlet("/display_book_details")
public class display_book_details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public display_book_details() {
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
			
			out.println("<h1>Book Details</h1>");
			out.println("<table border='2' style='border-collapse: collapse;'>");
			out.println("<tr>");
			out.println("<th style='padding: 10px;'> ID </th>");
			out.println("<th style='padding: 10px;'> Name </th>");
			out.println("<th style='padding: 10px;'> Price </th>");
			out.println("<th style='padding: 10px;'> Author </th>");
			out.println("<th style='padding: 10px;'> Action </th>");
			out.println("</tr>");

			while (r.next()) 
			{
			     int bid = r.getInt("bid");
			     bname = r.getString("bname");
			     bprice = r.getString("bprice");
			     aname = r.getString("aname");
			     String deleteURL="delete_book?bid="+bid;
			     String updateURL= "update_book?bid="+bid+"&bname="+bname+"&bprice="+bprice+"&aname="+aname;
			     
			    out.println("<tr>");
			    out.println("<td style='padding: 10px;'>" + bid + "</td>");
			    out.println("<td style='padding: 10px;'>" + bname + "</td>");
			    out.println("<td style='padding: 10px;'>" + bprice + "</td>");
			    out.println("<td style='padding: 10px;'>" + aname + "</td>");
			    out.println("<td style='padding: 10px;'>" + "<a href='"+deleteURL+"'>"+"Delete"+"</a><br><br>" +  "<a href='"+updateURL+"'>"+"Update"+"</a><br><br>" + "</td>");
			    out.println("</tr>");
			}
			out.println("</table>");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
