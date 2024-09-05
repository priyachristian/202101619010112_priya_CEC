

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class book_details
 */
@WebServlet("/book_details")
public class book_details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public book_details() {
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
		
		String bid=request.getParameter("bid");
		String bname=request.getParameter("bname");
		String bprice=request.getParameter("bprice");
		String aname=request.getParameter("aname");
		
		String deleteURL="delete_book?bid="+bid;
	    String updateURL= "update_book?bid="+bid+"&bname="+bname+"&bprice="+bprice+"&aname="+aname;
		
		out.println("<h1>Book Details</h1>");
		out.println("<h4>Book ID : "+bid+"</h4>");
		out.println("<h4>Book name : "+bname+"</h4>");
		out.println("<h4>Book price : "+bprice+"</h4>");
		out.println("<h4>Author name : "+aname+"</h4>");
	    out.println("<a href='"+deleteURL+"'>"+"Delete"+"</a>" +"    "+  "<a href='"+updateURL+"'>"+"Update"+"</a><br><br>" );

		
		
		
	}

}
