import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	private GradeBook gb1;
	private GradeBook gb2;
	private GradeBook gb3;

	@BeforeEach
	void setUp() throws Exception {
		/*
		 * Create 3 object of GradeBook with size 5 then call addScore() method for each
		 */
		gb1 = new GradeBook(5);
		gb1.addScore(50);
		gb1.addScore(75);

		gb2 = new GradeBook(5);
		gb2.addScore(8);
		gb2.addScore(9);
		gb2.addScore(10);
		gb2.addScore(9);

		gb3 = new GradeBook(5);
		gb3.addScore(7);
		gb3.addScore(10);
		gb3.addScore(8);

	}

	@AfterEach
	void tearDown() throws Exception {
		gb1 = null;
		gb2 = null;
		gb3 = null;
	}

	/*
	 * Use the toString method to compare the contents of what is in the scores
	 * array vs. what is expected to be in the scores array assertTrue()
	 */
	@Test
	void testAddScore() {
		assertTrue(gb1.toString().equals("50.0 75.0"));
		assertTrue(gb2.toString().equals("8.0 9.0 10.0 9.0"));
		assertTrue(gb3.toString().equals("7.0 10.0 8.0"));

		/*
		 * Compare the scoreSize to the expected number of scores entered, using
		 * assertEquals(. . .)
		 */
		assertEquals(2, gb1.getScoreSize());
		assertEquals(4, gb2.getScoreSize());
		assertEquals(3, gb3.getScoreSize());
	}

	/*
	 * Compare what is returned by sum() to the expected sum of the scores entered.
	 */
	@Test
	void testSum() {
		assertEquals(125, gb1.sum(), .0001);
		assertEquals(36, gb2.sum(), .0001);
		assertEquals(25, gb3.sum(), .0001);
	}

	/*
	 * Compare what is returned by minimum() to the expected minimum of the scores
	 * entered.
	 */
	@Test
	void testMinimum() {
		assertEquals(50, gb1.minimum(), .001);
		assertEquals(8, gb2.minimum(), .001);
		assertEquals(7.0, gb3.minimum(), .001);
	}

	/*
	 * • Compare what is returned by finalScore() to the expected finalScore of the
	 * scores entered. The finalScore is the sum of the scores, with the lowest
	 * score dropped if there are at least two scores, or 0 if there are no scores
	 */
	@Test
	void testFinalScore() {
		assertEquals(75.0, gb1.finalScore());
		assertEquals(28.0, gb2.finalScore());
		assertEquals(18.0, gb3.finalScore());
	}
}
