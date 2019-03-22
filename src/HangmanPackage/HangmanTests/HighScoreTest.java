package HangmanPackage.HangmanTests;
import static org.junit.jupiter.api.Assertions.assertEquals;





import org.junit.jupiter.api.Test;
import HangmanPackage.HighScore;
public class HighScoreTest {
	// Testing that highScore gets added and returned
	@Test
	void testAddHighScore() {
		int ten = 10;
		String name1 = "Winner";
		int twenty = 20;
		String name2 = "loser";
		int forty = 40;
		HighScore.addScore(ten, name1);
		HighScore.addScore(twenty, name2);
		HighScore.addScore(forty, name2);
		String expected = "Winner has the lowest amount of guesses with a total of 10 guesses";
		String accual = HighScore.getHighScore();
		assertEquals(expected, accual);
		 HighScore.emptyHighScore();
	}
	
	 @Test
	 void testGetHighScore() {
		String accual = HighScore.getHighScore();
		String expected = "no highscore saved";
		assertEquals(expected, accual);
		String name2 = "KalleWin";
		int two = 2;
		HighScore.addScore(two, name2);
		accual = HighScore.getHighScore();
		expected = "KalleWin has the lowest amount of guesses with a total of 2 guesses";
		assertEquals(expected, accual);
		 HighScore.emptyHighScore();
		 
	 }
	

	
}
