package HangmanPackage.HangmanTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import HangmanPackage.HighScore;
public class HighScoreTest {

	
	
	// Testing that highScore gets added
	@Test
	void testAddHighScore() {
		ArrayList<Integer> HScore = new ArrayList<Integer> ();
		int one = 1;
		int two = 2;
		int four = 4;
		int twenty = 20;
		int nintey = 90;
		int ten = 10;
		HighScore.addScore(four);
		HighScore.addScore(twenty);
		HighScore.addScore(nintey);
		HighScore.addScore(two);
		HighScore.addScore(one);
		HScore = HighScore.getHighScore();
		int accualSize = HScore.size();
		int expectedSize = HScore.size();
		// Test that all integers are there
		assertEquals(accualSize, expectedSize);
		HighScore.addScore(ten);
		 accualSize = HScore.size();
		expectedSize = accualSize;
		assertEquals(expectedSize, accualSize);
		
		// Test max and min
		int maxInHScore = Collections.max(HScore);
		int minInHScore = Collections.min(HScore);
		assertEquals(maxInHScore, nintey);
		assertEquals(minInHScore, one);
	}
	
	
	// Testing that highscore gets sorted
	@Test
	void testSortHighScore() {
		HighScore.resetHighscore();
		ArrayList<Integer> HScore2 = new ArrayList<Integer> ();
		HScore2 = HighScore.getHighScore();
		int one = 1;
		int six = 6;
		int seven = 7;
		int eight = 8;
		int nine = 9;
		int ten = 10;
		HighScore.addScore(seven);
		HighScore.addScore(eight);
		HighScore.addScore(nine);
		HighScore.addScore(one);
		HighScore.addScore(six);
		HighScore.addScore(ten);
		int firstPlace = HScore2.get(0);
		int lastPlace = HScore2.get(5);
		assertEquals(firstPlace, ten);
		assertEquals(lastPlace, one);
		
		// Check that its actually sorted
		for(int i = 0; i < HScore2.size() - 1; i++) {
			assertTrue(HScore2.get(i) > HScore2.get(i+1));
		}
		
	}
	
}
