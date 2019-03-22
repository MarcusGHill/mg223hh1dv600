package HangmanPackage.HangmanTests;
import HangmanPackage.HighScore;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class checkNickNamesTest {
	@Test
	void checkNickNameTest() {
		HighScore.addScore(10, "Winner name");
		String expected = "Winner name";
		String accual = HighScore.getNicknameOfWinner();
		assertEquals(expected, accual);
		HighScore.addScore(5, "new Winner name");
		expected = "new Winner name";
		accual = HighScore.getNicknameOfWinner();
		assertEquals(expected, accual);
		HighScore.addScore(1, "finalWinner");
		expected = "finalWinner";
		accual = HighScore.getNicknameOfWinner();
		assertEquals(expected, accual);
	}
}
