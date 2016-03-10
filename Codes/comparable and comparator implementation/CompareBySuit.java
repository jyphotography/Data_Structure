/********************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * Lecture 9 Sorting in Java 
 * Simple Card class with Comparable and Comparator
 *
 ********************************************************/
import java.util.Comparator;

public class CompareBySuit implements Comparator<Card> {

	@Override
	public int compare(Card x, Card y) {
		return x.getSuit().compareTo(y.getSuit());
	}

}
