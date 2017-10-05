package mystuff;

public class FakeQuiz {
	private int iCurrentQuestion = 0;
	
	private static final String[] returnedJSON = {
		"{\"nextQuestionNumber\":1,\"questionsRemaining\":3,\"nextQuestion\":\"aqt\",\"serverString\":\"Welcome!\",\"guessResponse\":\"\"}",
		"{\"nextQuestionNumber\":2,\"questionsRemaining\":2,\"nextQuestion\":\"acr\",\"serverString\":\"\",\"guessResponse\":\"wrong\"}",
		"{\"nextQuestionNumber\":3,\"questionsRemaining\":1,\"nextQuestion\":\"bgo\",\"serverString\":\"\",\"guessResponse\":\"correct\"}",
		"{\"nextQuestionNumber\":4,\"questionsRemaining\":0,\"nextQuestion\":\"cow\",\"serverString\":\"\",\"guessResponse\":\"wrong\"}",
		"{\"guessResponse\": \"correct\", \"programEnded\": \"true\"}",
	};
	
	public String getJSON(String command, String userResponse) {
		if (command != null && command.equals("start")) { iCurrentQuestion = 0; }
		if (iCurrentQuestion > 4) { return "{}"; }
		return returnedJSON[iCurrentQuestion++];
	}
}
