/********************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * Lecture 13 Hashing in Java, HashMap and HashSet
 * HashSet demo
 *
 ********************************************************/

import java.util.*;

public class HashSetDemo {

	public static void main(String[] args) {
		Set<String> distinctWords = new HashSet<String>();

		String[] words = "coming together is a beginning keeping together is progress working together is sucess"
				.split(" ");

		for (String word : words)
			distinctWords.add(word);

		System.out.println("There are " + distinctWords.size()
				+ " distinct words.");
		System.out.println("They are " + distinctWords);

		for (String word : distinctWords) {
			System.out.println(word);
		}
	}

}