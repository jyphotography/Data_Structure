/********************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * Lecture 9 Sorting in Java 
 * Simple Card class with Comparable and Comparator
 *
 ********************************************************/

import java.util.*;

public class MainDriver {

	public static void main(String[] args) {
		Card card1 = new Card("heart",1);
		Card card2 = new Card("diamond",1);
		
		System.out.println(card1.compareTo(card2));
		System.out.println(card1.equals(card2));
		
		List<Card> cards = new ArrayList<Card>(5);
		Card card3 = new Card("heart", 2);
		Card card4 = new Card("diamond", 2);
		Card card5 = new Card("spade", 3);
		Card card6 = new Card("club", 4);
		Card card7 = new Card("heart", 1);
		
		cards.add(card3); cards.add(card4); cards.add(card5);
		cards.add(card6); cards.add(card7);
		
		Collections.sort(cards);
		//Collections.sort(cards, new CompareBySuit());
		for(Card card:cards)
			System.out.println(card.toString());
	}

}