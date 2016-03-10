/*****************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * Lecture 7 Queue
 * Simple Queue Interface
 *
 *****************************************************/

public interface QueueInterface<AnyType> {
	/**
	 * enqueues a new element to the back of the queue in O(1)
	 * @param e a new element to add
	 */
	void enqueue(AnyType e);
	
	/**
	 * gets and deletes an element from the front of the queue in O(1)
	 * @return the first element in the queue
	 */
	AnyType dequeue();
	
	/**
	 * gets an element from the front of the queue in O(1)
	 * but does not delete it
	 * @return the first element in the queue
	 */
	AnyType peekFront();
	
	/**
	 * check if the queue is empty or not in O(1)
	 * @return true if the queue is empty, false if not
	 */
	boolean isEmpty();
}