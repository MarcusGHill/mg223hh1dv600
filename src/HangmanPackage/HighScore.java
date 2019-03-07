package HangmanPackage;

import java.util.ArrayList;
import java.util.Collections;

public class HighScore {
private static ArrayList<Integer> HighScore = new ArrayList<Integer> ();
	
	public static void addScore(int score) {
		HighScore.add(score);
		Collections.sort(HighScore, Collections.reverseOrder());
	}
	
	public static ArrayList<Integer> getHighScore() {
		return HighScore;
	}
	
	
	public static void resetHighscore() {
		HighScore.clear();
	}
}
