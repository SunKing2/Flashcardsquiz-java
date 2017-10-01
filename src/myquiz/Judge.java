package myquiz;

public class Judge {

	public boolean checkAnswer(Question q, String submitted_response) {
		return q.getAnswer().toLowerCase().equals(submitted_response.toLowerCase());
	}
}
