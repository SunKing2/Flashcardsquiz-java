package myquiz;

import static org.junit.Assert.*;

import org.junit.Test;

public class JudgeTest {
    
    Judge judge = new Judge();

    @Test
    public void testCheckAnswer_Correct() {
        Question q = new Question("BLO", "LOB");
        q.setAnswer("LOB");
        assertTrue(judge.checkAnswer(q, "LOB"));
    }
    @Test
    public void testCheckAnswer_Incorrect() {
        Question q = new Question("BLO", "LOB");
        q.setAnswer("LOB");
        assertFalse(judge.checkAnswer(q, "i don't know"));
    }
}
