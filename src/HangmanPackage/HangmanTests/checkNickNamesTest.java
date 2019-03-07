package HangmanPackage.HangmanTests;
import HangmanPackage.Nickname;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class checkNickNamesTest {

	@Test
	void checkNickNameTest() {
		assertTrue(Nickname.checkNickNames());
	}
}
