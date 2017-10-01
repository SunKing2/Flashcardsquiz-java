package myquiz;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FirstController {
	private Questions questions = null;
	private Question currentQuestion = null;
	private String message = "";
	private FilePersistentStorage storage = new FilePersistentStorage("java_questions_ctr.dat");
	private Judge judge = new Judge();
	
	// this controller stores independent info for each user, 
	public FirstController(String userName) throws FileNotFoundException, ClassNotFoundException, IOException {
		questions = new Questions();
	}
	
	// a user calls getMessage to see if the system has messages for him
	public String getMessage() {
		return message;
	}
	
	// a user calls sendMessage when he has something to send to the system
	public String sendMessage(String action, String message) {
		String sReturn = "";
		try {
    		if (action.equals("submit")) {
    			boolean correct = judge.checkAnswer(currentQuestion, message);
    			if(correct) {
    				currentQuestion.updateAsCorrect(2);
    				sReturn = "correct:" + currentQuestion.getRating();
    			}
    			else {
    				currentQuestion.updateAsIncorrect();
        			sReturn = "nope." + currentQuestion.answer;
    			}
    		}
    		else if (action.equals("next")) {
    			sReturn = getNextQuestionAndPrompt();
    		}
    		else if (action.equals("restart")) {
    			questions =  storage.retrieve();
    			questions.resetStart();
    		}
    		else if (action.equals("retrieve")) {
    			questions =  storage.retrieve();
    			questions.resetStart();
    			sReturn = "retrieved, what's next?";
    		}
    		else if (action.equals("store")) {
    			storage.store(questions);
    			sReturn += "\nall done, saved updated data.";
    		}
    		else if (action.equals("list")) {
    			sReturn += questions.toString();
    		}
		}
		catch (Exception exc) {
			exc.printStackTrace();
			sReturn += exc.toString();
			System.out.println(exc);
		}
		return sReturn;
	}

	private String getNextQuestionAndPrompt() {
		String sReturn;
		currentQuestion = questions.getNextQuestion();
		sReturn = currentQuestion.question + ": ";
		return sReturn;
	}
	
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		Scanner scan = new Scanner(System.in);
		
		
		FirstController cont = new FirstController("SunKing2");
		String sSystem = "";
		while (true) {
			System.out.println(":");
			String userInput = scan.next();
			// if user input with . it is a command
			if (userInput.charAt(0) == '.') {
				if (userInput.equals(".quit")) break;
				else if (userInput.equals(".stop")) break;
				String sMessage = userInput.substring(1);
				sSystem = cont.sendMessage(sMessage, sMessage);
			}
			// otherwise it must be a response to a question
			else {
				sSystem = cont.sendMessage("submit", userInput);
			}
			System.out.println(sSystem);
		}
		System.out.println("Thanks for hanging out! Bye.");
		scan.close();
	}
}
