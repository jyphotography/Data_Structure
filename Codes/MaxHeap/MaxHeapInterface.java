/********************************************************
 * 
 * 95-772 Data Structures for Application Programmers 
 * Lecture 18 Heaps and Heap Sort
 * 
 * MaxHeap Interface (insertion and removeMax)
 * 
 ********************************************************/

public interface MaxHeapInterface {
	/**
	 * Insert a new value into a heap
	 * 
	 * @param value
	 *            value to be inserted
	 * @return boolean to check whether it is added or not
	 */
	boolean insert(double value);

	/**
	 * remove the highest priority value (maximum if it is max heap)
	 * 
	 * @return removed value
	 */
	double removeMax();
}