import java.util.Scanner;

/**
 * Hangman for CS 2405 A01
 * 
 * @author Cory Britton
 */
public class HangmanApp {
	public static void main(String[] Args) {
		Scanner input = new Scanner(System.in);
		StringBuilder wordLetters = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		boolean hadMatch = false;
		String word;
		int numOfCharacters = 0;
		int lives = 6;
		String one;
		String two;

		System.out.print("Enter the word to test my app with: ");
		word = input.nextLine().toLowerCase();
		numOfCharacters = word.length();
		for (int i = 0; i < numOfCharacters; i++) {
			wordLetters.append(word.charAt(i) + " ");
			sb.append("_ ");
		}
		int newLength = wordLetters.length();

		// start of game
		System.out.println("HANGMAN");
		System.out.println(sb + "<- here is your word");
		System.out.println();
		do {
			System.out.print("Your guess: ");
			String guess = input.next().toLowerCase();
			char letter = guess.charAt(0);
			int index = wordLetters.indexOf(guess);
			for (int i = 0; i < newLength; i++) {
				char match = wordLetters.charAt(i);

				if (letter == match) {
					sb.replace(index, (index + 1), guess);
					index = wordLetters.indexOf(guess, index + 1);
					hadMatch = true;
				}
			}
			if (!hadMatch) {
				lives--;
			}
			hadMatch = false;
			System.out.println(sb + "  (Lives left: " + lives + ")");
			System.out.println();
			one = wordLetters.toString();
			two = sb.toString();
		} while (lives > 0 && !one.equals(two));
		if (lives == 0) {
			System.out.println("The word was " + word + ". Try again");
		} else {
			System.out.println("Congratulations, you win");
		}
		input.close();

	}
}
