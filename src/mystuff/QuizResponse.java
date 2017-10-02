package mystuff;

public class QuizResponse {
	public int nextQuestionNumber;
	public int questionsRemaining;
	public String nextQuestion;
	public String serverString;
	
	QuizResponse(int qn, int qr, String nq, String serverString) {
		this.nextQuestionNumber = qn;
		this.questionsRemaining = qr;
		this.nextQuestion = nq;
		this.serverString = serverString;
	}
}
