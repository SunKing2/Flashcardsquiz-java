package notused2;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class QuizAppHandler implements AppHandler {

	private int currentQuestion = 0;
	private String[] questions = {"aqt", "acr", "bgo", "cow"};
	//private String[] answers   = {"qat", "car", "bog", "cow"};

	@Override
	public String processJSON(Map<String, String> requestMap) {
		String sReturn = "{ \"serverString\" : \"correct\" }";
		
		if (requestMap.get("command") != null &&
				requestMap.get("command").equals("start")) {
			currentQuestion = 0;
		}
		
		sReturn = fakeJSON(currentQuestion);

		currentQuestion++;
		if (currentQuestion > 4) {
			currentQuestion = -1;
			sReturn = "{\"guessResponse\": \"correct\", \"programEnded\": \"true\"}";
		}
		
		return sReturn;
	}
	private String fakeJSON(int questionNumber) {
		String sReturn = "{ \"serverString\" : \"correct\" }";
		try {
			String guessResponse = questionNumber %2 == 0 ? "correct" : "wrong";
			String serverString = "";
			if (questionNumber == 0) {
				serverString = "Welcome!";
				guessResponse = "";
			}
			QuizResponse qr = new QuizResponse(currentQuestion+1, 3 - currentQuestion, questions[currentQuestion], serverString, guessResponse);
			sReturn = new ObjectMapper().writeValueAsString(qr);
		}
		catch (Exception exc) {
			System.out.println("QuizAppHandler.fakeJSON:" + exc);
		}
		return sReturn;
	}
}
