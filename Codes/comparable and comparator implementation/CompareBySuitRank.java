/********************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * Lecture 9 Sorting in Java 
 * Simple Card class with Comparable and Comparator
 *
 ********************************************************/
import java.util.Comparator;

public class CompareBySuitRank implements Comparator<Card> {

	@Override
	public int compare(Card x, Card y) {
		int suitResult = x.getSuit().compareTo(y.getSuit());
		if(suitResult == 0)
			return x.getRank() - y.getRank();
		else 
			return suitResult;
		
		// ternary expression
		// return suitResult != 0 ? suitResult : x.getRank() - y.getRank();
	}

}
