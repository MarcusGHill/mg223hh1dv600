package HangmanPackage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Scanner;

public class HangmanLogic {

	private ArrayList <String> hangman = new ArrayList<String>();
    private  Scanner sc = new Scanner(System.in);
    private String userGuess;
    private char userValidatedGuess;
    private Boolean validatedGuess = false;
    private Boolean validatedChoice = false;
    private String userChoice;
    private ReadWordsFromWeb rwfw = new ReadWordsFromWeb();
    private ArrayList<String> gameWords = new ArrayList<String>();
    private int random;
    private String gameWord;
    private char[] ghostWord;
    private String wrongGuesses = "";
    
    private int wrongGuess = 0;
    private Boolean matchFound = false;
    private Boolean gameStarted = false;
    private Boolean winGame = false;
    private char[] testForMatch;
	
 public void initializeHangMan () {
		hangman.add("   ____");
		hangman.add( "  |    o  ");
		hangman.add( "  |   /|\\   ");
		hangman.add( "  |    |  ");
		hangman.add( "  |   / \\");
		hangman.add( " _|_ ");
		hangman.add(" |   |______  ");
		hangman.add( "|          |  ");
		hangman.add("|__________| ");
 
 }
 public void getNextPiece (int amountOfWrongGuesses) {
	  System.out.println(hangman.get(amountOfWrongGuesses));
	  if(amountOfWrongGuesses == 8) {
		  System.out.println("GAME OVER!, hit Enter to restart application, the answer was " + gameWord);
		userGuess = sc.nextLine();
		try {
			menu();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	  }
			 
 }
 
 public void getUserInput() {
	 validatedGuess = false;
	while(validatedGuess == false) {
	 System.out.println("Please enter a letter");
	 userGuess = sc.nextLine();
	 if(userGuess.length() == 1 && Character.isLetter(userGuess.charAt(0))) {
	 validatedGuess = true;
	 userValidatedGuess = userGuess.charAt(0);
	 } else if(userGuess.toLowerCase().equals("quit")) {
		 System.out.println("Are you sure you want to terminate?  yes / no. ");
		 userGuess = sc.nextLine();
		 if(userGuess.toLowerCase().equals("yes")) {
		 System.exit(0);
		 } 
	 }
	}
	 
 }
 
 public void menu() throws IOException, MalformedURLException {
	 System.out.println("--welcome, to start game type start and press Enter");
	 System.out.println();
	 System.out.println("--if you want to choose what wikipedia site to fetch your words from type the adress");
	 System.out.println("and press enter to start the game. Type quit at any time terminate the application");
	 System.out.println("Example https://en.wikipedia.org/wiki/Stockholm");
	 initializeHangMan();
	 wrongGuesses = "";
	 validatedChoice = false;
	 matchFound = false;
	 wrongGuess = 0;
	 gameStarted = false;
	 while(validatedChoice == false) {
		 userChoice = sc.nextLine();
		 if(userChoice.toLowerCase().equals("start")) {
			 rwfw.ReadInput("");
			 gameLogic();
		 } else if(userChoice.toLowerCase().contains("wikipedia")) {
				 rwfw.ReadInput(userChoice.toLowerCase());
			 gameLogic();
		 } else if(userChoice.toLowerCase().equals("quit")) {
			 System.out.println("Are you sure you want to terminate?  yes / no. ");
			 userGuess = sc.nextLine();
			 if(userGuess.toLowerCase().equals("yes")) {
			 System.exit(0);
		 } else {
			 System.out.println();
			 System.out.println("Could not understand command, Please try again");
			 System.out.println();
			 menu();
		 }
	 }
	 }
	
 }
 
 public void gameLogic() {
	 chooseRandomWord();
	 while(wrongGuess < 10) {
		 System.out.println();
		 System.out.println("amount of wrong guesses = " + wrongGuess);
		 System.out.println("your wrong guesses = " + wrongGuesses);
		 gameField();
		 getUserInput();
		 testGuess();
		 
	 }
 }
 
 public void chooseRandomWord() {
	gameWords = rwfw.getResult();
	random = (int)(Math.random() * gameWords.size() + 0);
	gameWord = gameWords.get(random).toLowerCase();
 }
 
 public void gameField() {
	 if(gameStarted == false) {
	 ghostWord = new char[gameWord.length()];
	 for(int i = 0; i < gameWord.length(); i++) {
		 ghostWord[i] = '.';
		 System.out.print(ghostWord[i]);
	 }
	 } 
	 System.out.println();
 }
 
 public void testGuess() {
	 gameStarted = true;
	 matchFound = false;
	 for(int i = 0; i < gameWord.length(); i++) {
		 if(userValidatedGuess == gameWord.charAt(i)) {
			 ghostWord[i] = userValidatedGuess;
			 matchFound = true;
			 }
		 System.out.print(ghostWord[i]);
		 }  
	 testIfWin();

	 if (matchFound == false) {
		 wrongGuess++;
		 wrongGuesses = wrongGuesses + " " + userValidatedGuess;
		 System.out.println();
		 for(int i = 0; i < wrongGuess; i++) {
			 getNextPiece(i);
		 }
	 }
 }
 
 public void testIfWin() {
	 testForMatch = new char[gameWord.length()];
	 for(int i = 0; i < gameWord.length(); i++) {
		 testForMatch[i] = gameWord.charAt(i);
	 } 
	 winGame = true;
	 int i = 0;
	while(winGame == true && i < gameWord.length()) {
		
		if(ghostWord[i] == testForMatch[i] ) {
			winGame = true;
		} else {
			winGame = false;

		}
		i++;
	}
	if(winGame == true) {

		System.out.println();
		  System.out.println("YOU WON!, hit Enter to restart application");
			System.out.println();
			userGuess = sc.nextLine();
			try {
				menu();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
	}
 }
 
}
