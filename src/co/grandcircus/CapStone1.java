package co.grandcircus;

import java.util.Arrays;
import java.util.Scanner;

public class CapStone1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// get the word from the user
		String userInput;
		// String vowel;
		char userChar;
		userChar = 'y';

		System.out.println("Welcome to the Pig Latin Translator!");

		System.out.println();
		while (userChar == 'y') {

		System.out.println("Enter a line to be translated: ");
		userInput = scan.nextLine();
		String[] wholeSentence = userInput.split(" ");
		for(int i = 0; i < wholeSentence.length; i++) {
			translateWord(wholeSentence [i]);
		
		}
//			
			System.out.println("\nTranslate another line? (y/n): ");
			userChar = scan.nextLine().charAt(0);
		
		}
			System.out.println("Thank you come again!");
			

		

		scan.close();
	}

	private static void translateWord(String userInput) {
		// checking to see if the word has a vowel
		if (userInput.contains("a") || userInput.contains("e") || userInput.contains("i") || userInput.contains("o")
				|| userInput.contains("u")) {
			// checking to see if the vowel is in the first location 0 index
			if (userInput.charAt(0) == 'a' || userInput.charAt(0) == 'e' || userInput.charAt(0) == 'i'
					|| userInput.charAt(0) == 'o' || userInput.charAt(0) == 'u') {
				// if it is there it will print the word + way
				System.out.print(userInput + "way ");

			} else {
				// we know the word has vowels, so we're checking to see which vowels exist
				int[] indexOfArray = { userInput.indexOf("a"), userInput.indexOf("e"), userInput.indexOf("i"),
						userInput.indexOf("o"), userInput.indexOf("u") };
				// this is our test print for the Array to the location, if -1 is assign the
				// vowel doesn't exist
				//System.out.println(Arrays.toString(indexOfArray));
				// temporary variable for us to track the location of the first index of the
				// vowel
				int lowestVowelIndex = Integer.MAX_VALUE;
				// looping through the Array to find the first index
				for (int i = 0; i < indexOfArray.length; i++) {
					// as long as the value of the index is not -1 then we will assign the value to
					// the vowelIndex variable
					if (indexOfArray[i] != -1) {
						int vowelIndex = indexOfArray[i];
						// if the vowelIndex is lower than the current lowestVowelIndex then we set the
						// lowestVowelIndex to the vowelIndex
						if (vowelIndex < lowestVowelIndex) {
							lowestVowelIndex = vowelIndex;
						}

					}
				}
				// splitting of the string to take the first part off before the vowel
				String beginning = userInput.substring(0, lowestVowelIndex);
				// where the vowel starts
				String vowelStart = userInput.substring(lowestVowelIndex);
				// printing the word where the vowel starts, adding the consonants and "ay" to
				// the end
				System.out.print(vowelStart + beginning + "ay ");
			}
		} else {
			// if the word doesn't have any vowels it doesn't translate
			System.out.println("This does not translate to pig latin!");
			System.out.println("Your word was: " + userInput);
		}
	}

}
