package mystuff;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/DoServlet", "/do" })
public class DoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DoHandler handler = new DoHandler();
       
    public DoServlet() {
        super();
    }    

	private Map<String, String> convertMap(Map<String, String[]> oldMap) {
		Map<String, String> newMap = new HashMap<>();
		for (String k : oldMap.keySet()) {
			newMap.put(k, oldMap.get(k)[0]);
		}
		return newMap;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> requestMap = convertMap(request.getParameterMap());
		
		String contentType = "text/html";
		
		String requestType = requestMap.get("type");
		if (requestType == null) requestType = "html";
		
		switch(requestType) {
		case "json": contentType = "application/json"; break;
		case "text": contentType = "text/plain";       break;
		default:     contentType = "text/html";        break;
		}
		
		response.setContentType(contentType);
		
	    PrintWriter out = response.getWriter();
	    out.println(handler.process(requestMap));
	    out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
