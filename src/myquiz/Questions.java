package myquiz;

import java.util.ArrayList;
import java.util.List;

public class Questions implements java.io.Serializable {
    
	private static final long serialVersionUID = 1949602093079158559L;

	private int current_index = 0;
    
    private static final String QUESTIONS = "HOP	HOP PHO POH	71	1504097032	C	\nBLO	LOB	33	1504711252	C	\nEGHU	HUGE	67	1503419418	C	\nEEGH	GHEE	45	1503750431	C	\nAEINOST	ATONIES	24	1504796064	C	\n";
    
    List<Question> questionList = new ArrayList<>();
    
    public Questions() {
    	System.out.println(QUESTIONS);
        for (String line : QUESTIONS.split("\n")) {
            questionList.add(new Question(line));
        }
    }
    
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	for (Question q: questionList) {
    		sb.append(q.toString());
    		sb.append('\n');
    	}
    	return sb.toString();
    }
    
    // TODO this is probably a kludge fix to this not resetting itself
    // to zero on a save
    // ideally there should be a mechanism to set to zero prior to storage.
    public void resetStart() {
    	this.current_index = 0;
    }
    
    public boolean hasNext() {
    	// current_index is really the index of the next question
    	// this is because of the ++
    	return current_index < questionList.size() - 1;
    }
    
    public int size() {
    	return questionList.size();
    }

    public Question getNextQuestion() {
        if (current_index < questionList.size()) {
            Question q = questionList.get(current_index++);
            return q;
        }
        else {
            return null;
        }
    }
    public void sort(int zeroIndexedFieldNumber){
    	if (zeroIndexedFieldNumber == 2) {
    		questionList.sort((p1, p2) -> p1.rating.compareTo(p2.rating));
    	}
    	if (zeroIndexedFieldNumber == 3) {
    		questionList.sort((p1, p2) -> p1.age.compareTo(p2.age));
    	}
    }
}
