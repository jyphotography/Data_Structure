/********************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * Lecture 18 Heaps and Heap Sort
 * 
 * A very simple driver to display Max Heap tree
 * and sort values using heap sort
 *
 ********************************************************/

import java.util.*;

public class MainDriver {

	public static void main(String[] args) {
		MaxHeap theHeap = new MaxHeap(20);
		theHeap.insert(24);
		theHeap.insert(5);
		theHeap.insert(45);
		theHeap.insert(10);
		theHeap.insert(45);
		theHeap.insert(56);
		theHeap.insert(17);
		theHeap.insert(24);
		theHeap.insert(19);
		theHeap.insert(20);

		double[] sorted = new double[theHeap.size()];
		for (int i = 0; i < sorted.length; i++)
			sorted[i] = theHeap.removeMax();

		System.out.println("Sorted in descending order: "
				+ Arrays.toString(sorted));
	}

}