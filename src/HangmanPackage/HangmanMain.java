package HangmanPackage;

import java.io.IOException;
import java.net.MalformedURLException;

public class HangmanMain {

	
	public static void main (String[] args) throws MalformedURLException, IOException {
		ReadWordsFromWeb rwfw = new ReadWordsFromWeb();
		HangmanLogic hl = new HangmanLogic();
		System.out.println(rwfw.ReadInput());
		hl.initializeHangMan();
		for(int i = 0; i < 9; i ++ ) {
			hl.getNextPiece();
		}
	
		

	}
}
