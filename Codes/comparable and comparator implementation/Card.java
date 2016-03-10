/********************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * Lecture 9 Sorting in Java 
 * Simple Card class with Comparable and Comparator
 *
 ********************************************************/
import org.apache.commons.lang3.builder.*;
import com.google.common.base.Objects;
import com.google.common.collect.*;

public class Card implements Comparable<Card> {
	private String suit;
	private int rank;
	
	public Card(String suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public int getRank() {
		return rank;
	}
	
	@Override
	public String toString() {
		return "Card [suit=" + suit + ", rank=" + rank + "]";
	}

	@Override
	public int compareTo(Card x) {
		return getRank() - x.getRank();
	}
	
	
	/************************************************************************
	 * 
	 * Example of compareTo, equals and hashCode methods using Commons Lang
	 *  
	 ************************************************************************/
	/*
	@Override
	public int compareTo(final Card other) {
		return new CompareToBuilder().append(suit, other.suit)
				.append(rank, other.rank).toComparison();
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Card))
			return false;
		Card castOther = (Card) other;
		return new EqualsBuilder().append(suit, castOther.suit)
				.append(rank, castOther.rank).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(suit).append(rank).toHashCode();
	}
	*/
	
	/************************************************************************
	 * 
	 *  Example of compareTo, equals and hashCode methods using Google Guava
	 *  
	 ************************************************************************/
	/*
	@Override
	public int compareTo(final Card other) {
		return ComparisonChain.start()
				.compare(suit, other.suit)
				.compare(rank, other.rank)
				.result();
	}

	@Override
	public boolean equals(final Object obj){
	    if(obj instanceof Card){
	        final Card other = (Card) obj;
	        return Objects.equal(suit, other.suit)
	            && Objects.equal(rank, other.rank);
	    } else{
	        return false;
	    }
	}
	
	@Override
	public int hashCode(){
	    return Objects.hashCode(suit, rank);
	}
	*/

}