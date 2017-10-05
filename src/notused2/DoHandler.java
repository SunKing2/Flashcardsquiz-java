package notused2;

import java.util.Map;
import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

public class DoHandler {
	
	// TODO inject me with DI
	private AppHandler appHandler = new QuizAppHandler();

	// TODO hardcoding a directory name, fix!
	private static final String WEB_CONTENT_DIRECTORY = "/home/louie/Documents/prog/workspace2017/Flashcardquiz-java/WebContent/";

	// normally a requestMap is <String, String[]> but 
	// you need to convert it before calling me!
	public String process(Map<String, String> requestMap) {
		String sReturn = "<html><body><h1>Hi! defaults are good! :)</h1></body></html>";
		
		if (requestMap.containsKey("type")){

			String requestType = requestMap.get("type");
			if (requestType == null) requestType = "";
			
			switch(requestType) {
			case "json": sReturn = processJSON(requestMap); break;
			case "text": sReturn = processText(requestMap); break;
			default:     sReturn = processHTML(requestMap); break;
			}
		}
		else {
			// no type was specified in request parameters:
			// if you got here, it must be HTML
			sReturn = processHTML(requestMap);
		}
			
		return sReturn;
	}
	
	private String processJSON(Map<String, String> requestMap) {
		String sReturn = "{ \"serverString\" : \"correct\" }";
		String sApp = requestMap.get("app");
		if (sApp != null && sApp.length() > 1) {
			sReturn = appHandler.processJSON(requestMap);
		}
		return sReturn;
	}
	private String processText(Map<String, String> requestMap) {
		String sReturn = "text";
		return sReturn;
	}
	private String processHTML(Map<String, String> requestMap) {
		String sReturn = "<html><body><h1>Hi! process HTML :)</h1></body></html>";
		
		String sPage = requestMap.get("page");
		if (sPage != null && sPage.length() > 1) {
			sReturn = readFile(sPage);
		}
		return sReturn;
	}
	
	private String readFile(String fileName) {
		String sReturn = "<html><body><h1>No such file! :(</h1></body></html>";
		try {
			fileName = WEB_CONTENT_DIRECTORY + fileName;
			sReturn = new String(readAllBytes(get(fileName)));
		}
		catch (Exception exc) {
			System.out.println("DoHandler.readFile:" + exc);
		}
		return sReturn;
	}
}
