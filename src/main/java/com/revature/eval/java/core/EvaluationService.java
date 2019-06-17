package com.revature.eval.java.core;

import java.lang.reflect.Parameter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EvaluationService {

	/**
	 * 1. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {

		char[] charray = new char[phrase.length()];
		String holder = " ";
		charray[0] = phrase.charAt(0);
		for(int i = 1; i < phrase.length(); i++){
			if (phrase.charAt(i) == ' ' || phrase.charAt(i) == '-'){
				charray[i] = phrase.charAt(i + 1);
                System.out.println("ch[i]: "+charray[i]);
			}
			else {
				charray[i] =' ';
                System.out.println("else "+charray[i]);
			}

		}
		holder = new String(charray).replaceAll("\\s", "").trim();

		return holder.toUpperCase();


	}

	/**
	 * 2. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */


	public static int getScrabbleScore(String string) {

		// TODO Write an implementation for this method declaration
		//input all the scores into an array
		int[] myArray = {1,2, 3,4,5,8,10};
		char[] myInput = string.toLowerCase().toCharArray();
		int sum =0;
		for(int i=0;i<myInput.length; i++){
			switch(myInput[i]){
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
				case 'l':
				case 'n':
				case 'r':
				case 's':
				case 't':
					sum += myArray[0];
					break;

				case 'd':
				case 'g':
					sum += myArray[1];
					break;
				case 'b':
				case 'c':
				case 'm':
				case 'p':
					sum += myArray[2];
					break;
				case 'f':
				case 'h':
				case 'v':
				case 'w':
				case 'y':
					sum += myArray[3];
					break;
				case 'k':
					sum += myArray[4];
					break;
				case 'j':
				case 'x':
					sum += myArray[5];
					break;
				case 'q':
				case 'z':
					sum += myArray[6];
					break;
                default:
                    System.out.println("wrong input char!!! try again");
                    break;

			}


		}

		return sum;
}


	/**
	 * 3. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
		//TODO remove all space in the string
		string = string.replaceAll("\\s","");
		string = string.replaceAll("[^\\d]", "");
		if(string.charAt(0) == '1')
		//if first position of digit is 1 replace it with empty space
			string = string.replaceFirst("1", "");
		//if string > 11 throw an IllegalException
		if(string.length() > 11 || string.length()<10) {
			throw new IllegalArgumentException("your number is not right up to 11 digits");
		}
		for(int i = 0; i < string.length();i++){
			if(string.matches("/d")){
				throw new IllegalArgumentException("check your input values");
			}

			try {
				if(Character.isDigit(string.charAt(i)) && string.trim().length() == 11){
					 string = ""+Integer.parseInt(string.replaceAll("\\W",""));

				}
			 	}
			catch(IllegalArgumentException ex){

				System.out.println("Invalid Input");
			}

		}

		return string;

	}

	/**
	 * 4. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		// TODO Write an implementation for this method declaration
		Map<String, Integer> count = new HashMap<>();
		String[]convert = string.replaceAll("[^A-Za-z]"," ").split("\\s+");
		for (int i = 0; i<convert.length;i++){
			Integer c = count.get(convert[i]);
			if(count.get(convert[i]) == null){
				count.put(convert[i], 1);
			}
			else {
				count.put(convert[i],++c);
			}
		}

		return count;
	}

	/**
	 * 5. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;


		public int indexOf(T t) {
			List<Integer> listCollector = new ArrayList<>();
			listCollector.addAll((Collection<? extends Integer>) getSortedList());
			int min =0;
			int midPoint=0;
			int max = getSortedList().size();
			int targetInteger;
			int index =0;
//			return Arrays.binarySearch(sortedList.toArray(), t);
			targetInteger = Integer.parseInt(t.toString());

			while (min <= max){
				midPoint = (min + max)/2;

				if(midPoint == listCollector.indexOf(midPoint)){
					return midPoint;
				}

				if(listCollector.get(midPoint) < targetInteger){
						min = midPoint + 1;
				}
				else if(listCollector.get(midPoint) > targetInteger){
						max = midPoint - 1;
				}
				else if(listCollector.get(midPoint).equals(targetInteger)){
					return midPoint;

//					return targetInteger;
				}
			}
//			return  index = midPoint;
			return -1;

		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}
	}

	/**
	 * 6. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		// TODO Write an implementation for this method declaration

		boolean inputNotValid = false;
		char[] c = String.valueOf(input).toCharArray();
		int comparison = 0;

		for(char i : c) {
			comparison += Math.pow(Character.getNumericValue(i), c.length);
		}
		if(comparison == input) {
			inputNotValid = true;
		}
		else if(comparison != input) {
//			inputNotValid = false;
		}
		return inputNotValid;
	}

	/**
	 * 7. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		// TODO Write an implementation for this method declaration
		List<Long> listOfLongPrimes = new ArrayList<>();

		int countBreaker =(int)l;
		for(int i = 2; i<= countBreaker; i++) {

			while(l % i == 0) {

				listOfLongPrimes.add((long) i);
				l /=i;
			}

		}

		return listOfLongPrimes;
	}


	/**
	 * 8-9. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 8
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			string = string.toLowerCase();
			String cipher ="";
			for(char i : string.toCharArray()){
				if(Character.isLetter(i)){
					cipher += (char) (122 + (97-i));
				}
				else if(Character.isDigit(i)){
					cipher +=i;
				}

			}
			cipher = cipher.replaceAll("(.{5})", "$0 ");
			System.out.println(cipher);
			return cipher.trim();
		}

		/**
		 * Question 9
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			string = string.replaceAll("[^a-zA-Z\\d]","").toUpperCase();
			StringBuilder build = new StringBuilder();
			for(char c : string.toCharArray()){
				if(Character.isLetter(c)){
					int newChar = ('Z' - c) + 'A';
					build.append((char)newChar);
				}
				else {
					build.append(c);
				}
			}
			return new String(build).toLowerCase();
		}
	}

	/**
	 * 10. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		// TODO Write an implementation for this method declaration
		string = string.replaceAll("[?]", "");
		//System.out.println(string);
		int sum = 0;
		String[] s = string.toLowerCase().split(" ");
		System.out.println("s: " + s);
		int i = Integer.parseInt(s[2]);
		System.out.println("s[2] :" + s[2]);
		int j = Integer.parseInt(s[s.length -1]);
		System.out.println("print Question: " +s[3]);
		if(s[3].equals("plus")) {
			sum = i + j;
		}
		else if(s[3].equals("minus")) {
			sum = i - j;
		}
		else if(s[3].equals("multiplied")) {
			sum = i * j;
		}
		else if(s[3].equals("divided")) {
			sum = i / j;
		}

		return sum;

	}


}
