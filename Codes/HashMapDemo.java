/********************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * Lecture 13 Hashing in Java, HashMap and HashSet
 * HashMap demo
 *
 ********************************************************/

import java.util.*;

public class HashMapDemo {

	public static void main(String[] args) {
		// set the initial capacity of HashMap to be 10 and load factor to be 0.65
		// But, initial capacity will be set to 16 by its design.
		Map<String, Integer> freqOfWords = new HashMap<String, Integer>(10,
				0.65f);

		String[] words = "coming together is a beginning keeping together is progress working together is sucess"
				.split(" ");

		for (String word : words) {
			Integer frequency = freqOfWords.get(word);
			if (frequency == null)
				frequency = 1;
			else
				frequency++;
			freqOfWords.put(word, frequency);
		}

		System.out.println(freqOfWords);

		for (String word : freqOfWords.keySet()) {
			System.out.println(word);
		}
	}

}