package myquiz;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuestionsTest {
    
    private static final int QUESTIONS_IN_THIS_SET = 5;
    Questions questions = new Questions();

    @Test
    public void testGetQuestion() {
        Question q = questions.getNextQuestion();
        assertFalse(q.getQuestion().equals(""));
    }
    
    @Test
    public void testHasMoreThanOneQuestion() { 
        Question q = questions.getNextQuestion();
        Question q2 = questions.getNextQuestion();
        assertNotEquals(q.getQuestion(), q2.getQuestion());
    }
    
    @Test
    public void testEndOfGetQuestions(){
        int trying_this_many_nulls = 2;
        
        int nullCount = 0;
        int goodCount = 0;
        for(int i = 0; i < QUESTIONS_IN_THIS_SET + trying_this_many_nulls; i++) {
            Question q = questions.getNextQuestion();
            if (q == null) {
                nullCount++;
            }
            else {
                goodCount++;
            }
        }
        assertEquals(QUESTIONS_IN_THIS_SET, goodCount);
        assertEquals(trying_this_many_nulls, nullCount);
    }
    @Test
    public void testDefaultSortOrder() {
    	String[] questionArray = {"HOP", "BLO", "EGHU", "EEGH", "AEINOST"};
    	for (String sQuestion : questionArray) {
        	assertEquals(sQuestion, questions.getNextQuestion().getQuestion());
    	}
    }
    @Test
    public void testSortByRating() {
    	String[] questionArray = {"AEINOST", "BLO", "EEGH", "EGHU", "HOP"};
    	
    	questions.sort(2);
    	for (String sQuestion : questionArray) {
        	assertEquals(sQuestion, questions.getNextQuestion().getQuestion());
    	}
    }
    @Test
    public void testSortByAge() {
    	String[] questionArray = {"EGHU", "EEGH", "HOP", "BLO", "AEINOST"};
    	
    	questions.sort(3);
    	for (String sQuestion : questionArray) {
        	assertEquals(sQuestion, questions.getNextQuestion().getQuestion());
    	}
    }
}
