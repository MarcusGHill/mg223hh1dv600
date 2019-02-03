package HangmanPackage;

import java.util.ArrayList;

public class HangmanLogic {

	private ArrayList <String> hangman = new ArrayList<String>();
    private int count = 0;
	
 public void initializeHangMan () {
		hangman.add("   ____");
		hangman.add( "   |    o  ");
		hangman.add( "   |   /|\\   ");
		hangman.add( "   |     |  ");
		hangman.add( "   |   /  \\");
		hangman.add( " _|_ ");
		hangman.add(" |   |______  ");
		hangman.add( "|              |  ");
		hangman.add("|__________| ");
 
 }
 public void getNextPiece () {
	  System.out.println(hangman.get(count));
	  count++;
 }
 
}
