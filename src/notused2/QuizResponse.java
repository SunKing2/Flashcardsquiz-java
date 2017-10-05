package notused2;

public class QuizResponse {
	public int nextQuestionNumber;
	public int questionsRemaining;
	public String nextQuestion;
	public String serverString;
	public String guessResponse;
	
	QuizResponse(int nextQuestionNumber, 
			int questionsRemaining,
			String nextQuestion,
			String serverString,
			String guessResponse) {
		this.nextQuestionNumber = nextQuestionNumber;
		this.questionsRemaining = questionsRemaining;
		this.nextQuestion = nextQuestion;
		this.serverString = serverString;
		this.guessResponse = guessResponse;
	}
}
