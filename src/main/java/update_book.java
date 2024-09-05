

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
 * Servlet implementation class update_book
 */
@WebServlet("/update_book")
public class update_book extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update_book() {
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
        PrintWriter out = response.getWriter();

        String bid = request.getParameter("bid");
        String bname=request.getParameter("bname");
		String bprice=request.getParameter("bprice");
		String aname=request.getParameter("aname");
		
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gls", "root", "priya7504");
            
            PreparedStatement p = con.prepareStatement("SELECT * FROM book WHERE bid=?");
            p.setString(1, bid);
            ResultSet r = p.executeQuery();

            if (r.next()) 
            {
            	bname = r.getString("bname");
			    bprice = r.getString("bprice");
			    aname = r.getString("aname");
              
			    out.println("<h1>Update Book Details</h1>");
                out.println("<form action='update_book' method='POST'>");
                out.println("<input type='hidden' name='bid' value='" + bid + "'/>");
                out.println("Book Name: <input type='text' name='bname' value='" + bname + "'/><br/><br/>");
                out.println("Book Price: <input type='text' name='bprice' value='" + bprice + "'/><br/><br/>");
                out.println("Author Name: <input type='text' name='aname' value='" + aname + "'/><br/><br/>");
                out.println("<input type='submit' value='Update Book'/>");
                out.println("</form>");
            } 
            else 
            {
                out.println("<h1>Book not found!</h1>");
            }

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String bid = request.getParameter("bid");
        String bname = request.getParameter("bname");
        String bprice = request.getParameter("bprice");
        String aname = request.getParameter("aname");

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gls", "root", "priya7504");

            // Update the book details
            PreparedStatement p = con.prepareStatement("UPDATE book SET bname=?, bprice=?, aname=? WHERE bid=?");
            p.setString(1, bname);
            p.setString(2, bprice);
            p.setString(3, aname);
            p.setString(4, bid);

            int rowsUpdated = p.executeUpdate();

            if (rowsUpdated > 0) {
                out.println("<h1>Book Updated Successfully!</h1>");
            } else {
                out.println("<h1>Error: Could not update book details.</h1>");
            }

            out.println("<a href=\"display_book_details\">Show Book Details</a>");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h1>An error occurred while updating the book. Please try again.</h1>");
        }
		
		
	}

}
