package HangmanPackage;

public class HangmanMain {

	
	public static void main (String[] args) {
		ReadWordsFromWeb rwfw = new ReadWordsFromWeb();
		HangmanLogic hl = new HangmanLogic();
		rwfw.ReadInput();
		hl.printHangMan();
System.out.println("test");
	}
}
 