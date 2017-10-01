package mystuff;

public class QuizResponse {
	public int nextQuestionNumber;
	public String serverString;
	public String nextQuestion;
	
	QuizResponse(int qn, String s, String n) {
		this.nextQuestionNumber = qn;
		this.serverString = s;
		this.nextQuestion = n;
	}
}
