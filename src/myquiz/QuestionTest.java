package myquiz;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuestionTest {

	@Test
	public void testQuestionConstructor_string() {
		String sJunkData = "this is plain junk and won't make a question";
		Question q1 = null;
		Question q2 = null;
		q1 = new Question("BLO	LOB	33	1504711252	C\t");
		assertNotNull("q1: a question should be able to be made from 6 tab delimited strings:", q1);
		assertEquals("q1: question(string) should have correct answer", "LOB", q1.getAnswer());
		
		String sException = "";
		try {
			q2 = new Question(sJunkData);
		}
		catch (Exception exc) {
			sException += exc;
		}
		
		assertNull("q2: a question should throw an exception if constructor string is not 6 tab delited fields:" + sException, q2);
	}
	
	@Test
	public void testConstructor_Unseen() {
		Question q = new Question("quest\tans\t+100\t0\tCO\tmy note");
		assertTrue("question initialized with +100 should be unseen", q.getUnseen());
	}
	
	@Test
	public void testUpdateAsCorrect() {
		Question q = new Question("my q", "my a");
		q.updateAsCorrect(2);
		assertEquals("rating of updated new question should be around 2/3 * old_rating", 67, (int)q.getRating());
	}
	@Test
	public void testUpdateAsCorrect_slow() {
		Question q = new Question("my q", "my a");
		q.updateAsCorrect(10);
		assertEquals("rating of updated slow new question should be around 2/3 * old_rating + several", 70, (int)q.getRating());
	}
	@Test
	public void testUpdateAsCorrect_unseen() {
		Question q = new Question("my q", "my a");
		q.setUnseen(true);
		q.updateAsCorrect(2);
		assertEquals("rating of updated unseen new question should be just how many seconds it took to answer", 2, (int)q.getRating());
	}
	
	@Test
	public void testUpdateAsIncorrect() {
		Question q = new Question("my q", "my a");
		q.setRating(33);;
		q.updateAsIncorrect();
		assertEquals("rating of updated incorrect question should be max", 
				100, (int)q.getRating());
	}
	@Test
	public void testUpdatedQuestionIncorrect_time_and_unseen(){
		Question q = new Question("my q", "my a");
		q.setUnseen(true);
		q.updateAsIncorrect();
		int now = (int)(System.currentTimeMillis() / 1000);
		assertEquals("age of updated incorrect q should be now", 
				now, (int)q.getAge());
		assertFalse("updated question (as incorrect) should be flagged as seen", 
				q.getUnseen());
	}
	@Test
	public void testUpdatedQuestionCorrect_time_and_unseen(){
		Question q = new Question("my q", "my a");
		q.setUnseen(true);
		q.updateAsCorrect(2);
		int now = (int)(System.currentTimeMillis() / 1000);
		assertEquals("age of updated correct q should be now", 
				now, (int)q.getAge());
		assertFalse("updated question (as correct) should be flagged as seen", 
				q.getUnseen());
	}
}
