package mystuff;

import java.util.Map;

public class ServletController {

	public String process(Map<String, String[]> parameterMap) {
		String sReturn = "";
		
		try {
		
    		String[] x = parameterMap.get("type");
    		
    		System.out.println("?type value=" + x);
    		
    		if (parameterMap.get("type")[0].equals("application/json")) {
    			//sReturn = "{ \"serverString\":\"correct\" }";
    			sReturn = "{ \"serverString\" : \"correct\" }"; 
    		} 
		}
		catch (Exception exc) {
			System.out.println("ServletController.process cot:" + exc);
		}
		return sReturn;
	}
}
