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
		
		sReturn = fakeJSON(currentQuestion);

		currentQuestion++;
		if (currentQuestion > 3) {
			currentQuestion = 0;
		}
		
		return sReturn;
	}
	private String fakeJSON(int questionNumber) {
		String sReturn = "{ \"serverString\" : \"correct\" }";
		try {
			String sCorrect = questionNumber %2 == 0 ? "correct" : "wrong";
			QuizResponse qr = new QuizResponse(currentQuestion + 1, sCorrect, questions[currentQuestion+1]);
			sReturn = new ObjectMapper().writeValueAsString(qr);
		}
		catch (Exception exc) {
			System.out.println("QuizAppHandler.fakeJSON:" + exc);
			currentQuestion = 0;
		}
		return sReturn;
	}
}
