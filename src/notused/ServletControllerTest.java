package notused;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import java.io.StringReader;
import java.util.*;
import javax.json.*;

public class ServletControllerTest {
	
	private ServletController controller = new ServletController();
	private Map <String, String[]> map = new HashMap<>();

	@Test
	public void testProcess_notNullProcessingWithNullInput() {
		assertNotNull("should never return null", controller.process(null));
	}
	
	@Test
	public void testProcess_CanHandleZeroRequestParameters() {
		Map <String, String[]> emptyMap = new HashMap<>();
		assertNotNull("should handle zero_request_parameters", controller.process(emptyMap));
	}

	@Test
	public void testProcess_HasSomeResults() {
		String sReturn = controller.process(null);
		assertNotNull("should produce more than 2 characters of output for null input", sReturn.length() > 1);
	}
	
	@Test
	public void testProcess_ReturnsValidJson() {
		map.put("type", new String[]{"application/json"});
		String sReturn = controller.process(map);
		// just creating this will cause it to parse
		// if it doesn't parse, exception will be caused
		// (and of cours this test will fail, as we want)
		JsonReader jsonReader = Json.createReader(new StringReader(sReturn));
		jsonReader.readObject();
		jsonReader.close();
	}
}
