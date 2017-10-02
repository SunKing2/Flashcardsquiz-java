package notused;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FlashcardsServlet")
public class FlashcardsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ServletController controller = null;

    public FlashcardsServlet() throws FileNotFoundException, ClassNotFoundException, IOException {
    	controller = new ServletController();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter out = response.getWriter();
	    
	    System.out.println(request.getQueryString());
  		System.out.println(request.getParameter("json"));
		if (request.getParameter("json") != null) {
			response.setContentType("text/plain");
			out.println("{ \"serverString\":\"correct\" }\n");
			return;
		}
		// this servlet redirects to index.html
		// unless you pass it test=test
		else if (request.getParameter("test") == null) {
			request.getRequestDispatcher("index.html").forward(request, response);
			return;
		}
		

	      // Set response content type
	      response.setContentType("text/html");

	      String title = "Using GET Method to Read Form Data";
	      String docType =
	         "<!doctype html public \"-//w3c//dtd html 4.0 " +
	         "transitional//en\">\n";
	         
	      out.println(docType +
	         "<html>\n" +
	            "<head><title>" + title + "</title></head>\n" +
	            "<body bgcolor = \"#f0f0f0\">\n" +
	               "<h1 align = \"center\">" + title + "</h1>\n" +
	               "<ul>\n" +
	                  "  <li><b>First Name</b>: "
	                  + request.getParameter("first_name") + "\n" +
	                  "  <li><b>Last Name</b>: "
	                  + request.getParameter("last_name") + "\n" +
	               "</ul>\n" +
	               "      <form action = \"FlashcardsServlet\" method = \"POST\">\n" + 
	               "         First Name: <input type = \"text\" name = \"first_name\">\n" + 
	               "         <br />\n" + 
	               "         Last Name: <input type = \"text\" name = \"last_name\" />\n" + 
	               "         <input type = \"submit\" value = \"Submit\" />\n" + 
	               "      </form>" +
	            "</body>" +
	         "</html>"
	      );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
