package HangmanPackage;

public class HangmanMain {

	
	public static void main (String[] args) {
		ReadWordsFromWeb rwfw = new ReadWordsFromWeb();
		HangmanLogic hl = new HangmanLogic();
		rwfw.ReadInput();
		hl.initializeHangMan();
		for(int i = 0; i < 9; i ++ ) {
			hl.getNextPiece();
		}
	
		

	}
}
