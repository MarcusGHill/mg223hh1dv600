package HangmanPackage;

import java.io.IOException;
import java.net.MalformedURLException;

public class HangmanMain {
private static int wordMinSize = 9;
	
	public static void main (String[] args) throws MalformedURLException, IOException {

		HangmanLogic hl = new HangmanLogic();
		hl.menu();

	}
}
