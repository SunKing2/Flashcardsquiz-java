package mystuff;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class QuizAppHandler implements AppHandler {

	private int currentQuestion = 0;
	private String[] questions = {"aqt", "acr", "bgo", "cow"};
	private String[] answers   = {"qat", "car", "bog", "cow"};

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
			sReturn = "{\"serverString\": \"correct\", \"programEnded\": \"true\", \"guessResponse\" : \"true\"}";
		}
		
		return sReturn;
	}
	private String fakeJSON(int questionNumber) {
		String sReturn = "{ \"serverString\" : \"correct\" }";
		try {
			String sCorrect = questionNumber %2 == 0 ? "correct" : "wrong";
			if (questionNumber == 0) {
				sCorrect = "Welcome!";
			}
			Boolean guessResponse = questionNumber > 0;
			QuizResponse qr = new QuizResponse(currentQuestion+1, 3 - currentQuestion, questions[currentQuestion], sCorrect, guessResponse.toString());
			sReturn = new ObjectMapper().writeValueAsString(qr);
		}
		catch (Exception exc) {
			System.out.println("QuizAppHandler.fakeJSON:" + exc);
		}
		return sReturn;
	}
}
