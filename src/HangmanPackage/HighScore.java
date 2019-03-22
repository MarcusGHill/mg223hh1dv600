package HangmanPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
// Class holds, saves and retrives highscore
public class HighScore {
private static HashMap<Integer, String> HighScore = new HashMap<Integer, String>();
private static ArrayList <Integer> highScoreHelper = new ArrayList<Integer>();
private static boolean scoreEmpty = true;

	//Saves score and name in hashmap and keeps the scores sorted in highscoreHelper for fast access to nr1,
	public static void addScore(int score, String nickName) {
		HighScore.put(score, nickName);
		highScoreHelper.add(score);
		Collections.sort(highScoreHelper);
		scoreEmpty = false;
		
	}
	// Returns high score as string
	public static String getHighScore() {
		if(!scoreEmpty) {
		return HighScore.get(highScoreHelper.get(0)) + " has the lowest amount of guesses with a total of " +  
		highScoreHelper.get(0) + " guesses";
		} else {
			return "no highscore saved";
		}
	}
	
	public static void emptyHighScore() {
		HighScore.clear();
		highScoreHelper.clear();
		scoreEmpty = true;
	}
	//Returns nickname of the highscore leader
	public static String getNicknameOfWinner() {
		return HighScore.get(highScoreHelper.get(0));
	}
}
