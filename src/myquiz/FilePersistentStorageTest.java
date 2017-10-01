package myquiz;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class FilePersistentStorageTest {
	
	private FilePersistentStorage storage = new FilePersistentStorage("java_questions.dat");

	@Test
	public void testStore() throws FileNotFoundException, IOException, ClassNotFoundException {
		Questions qs = new Questions();
		storage.store(qs);
		
		Questions qs2 = storage.retrieve();
		Question q = qs2.getNextQuestion();
		assertEquals("stored question should have correct first question on retrieval",
				"HOP", q.getQuestion());
	}
}
