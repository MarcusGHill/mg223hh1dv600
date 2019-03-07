package HangmanPackage.HangmanTests;



import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import HangmanPackage.HangmanLogic;


class initializeHangManTest {

	// Test to make sure the hangman arraylist gets properly constructed
	@Test
	void testInitializeHangMan() {
		HangmanLogic hl = new HangmanLogic();
		hl.initializeHangMan();
		String Expected0fromTop = "   ____";
		String Expected1FromTop = "  |    o  ";
		String Expected2FromTop = "  |   /|\\   ";
		String Expected3FromTop = "  |    |  ";
		String Expected4FromTop = "  |   / \\";
		String Expected5FromTop = " _|_ ";
		String Expected6FromTop = "|   |______ ";
		String Expected7FromTop = "|          |  ";
		String Expected8FromTop = "|__________| ";
		assertEquals(hl.getHangman(0), Expected0fromTop);
		assertEquals(hl.getHangman(1), Expected1FromTop);
		assertEquals(hl.getHangman(2), Expected2FromTop);
		assertEquals(hl.getHangman(3), Expected3FromTop);
		assertEquals(hl.getHangman(4), Expected4FromTop);
		assertEquals(hl.getHangman(5), Expected5FromTop);
		assertEquals(hl.getHangman(6), Expected6FromTop);
		assertEquals(hl.getHangman(7), Expected7FromTop);
		assertEquals(hl.getHangman(8), Expected8FromTop);
	}
	
	
// Test to make sure that the index out of bounds exception gets thrown if hangman 
//	is not initialized or initialized but called with Index 9 (its only 0-8)

	@Test
	public void testIndexOutOfBoundsException() {
		HangmanLogic hl = new HangmanLogic();
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> hl.getHangman(0));
		hl.initializeHangMan();
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> hl.getHangman(9));
	}

}
