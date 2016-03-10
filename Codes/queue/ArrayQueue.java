/********************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * Lecture 7 Queue
 * Simple Queue implementation using an array (circular)
 *
 ********************************************************/
import java.util.NoSuchElementException;

public class ArrayQueue<AnyType> implements QueueInterface<AnyType> {
	
	private static final int DEFAULT_CAPACITY = 6;
	private AnyType[] array;
	private int front, back, nItems;
	
	/**
	 * construct a new queue with default capacity
	 */
	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		array = (AnyType[]) new Object[DEFAULT_CAPACITY];
		front = 0;
		back = -1;
		nItems = 0;
	}
	
	/**
	 * enqueues a new element to the back of the queue in O(1)
	 * @param e a new element to add
	 */
	@Override
	public void enqueue(AnyType e) {
		if(isFull()) 
			throw new RuntimeException("Queue is full");
		back++;
		int index = back % array.length;
		array[index] = e;
		nItems++;
	}

	/**
	 * gets and deletes an element from the front of the queue in O(1)
	 * @return the first element in the queue
	 */
	@Override
	public AnyType dequeue() {
		if(isEmpty())
			throw new NoSuchElementException();
		
		AnyType e = array[front%array.length];
		array[front%array.length] = null;
		front++; // front moves up to the right
		nItems--;
		return e;
	}

	/**
	 * gets an element from the front of the queue in O(1)
	 * but does not delete it
	 * @return the first element in the queue
	 */
	@Override
	public AnyType peekFront() {
		if(isEmpty())
			throw new NoSuchElementException();

		return array[front%array.length];
	}

	/**
	 * check if the queue is empty or not in O(1)
	 * @return true if the queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return nItems == 0;
	}
	
	// private helper method to check if queue is full or not
	private boolean isFull() {
		return nItems == array.length;
	}
	
	// a few test cases
	public static void main(String[] args) {
		ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
		queue.enqueue(1);
		queue.enqueue(3);
		System.out.println(queue.dequeue()); // 1
		System.out.println(queue.peekFront()); // 3
		queue.enqueue(2);
		queue.enqueue(10);
		queue.enqueue(5);
		queue.enqueue(4);
		queue.enqueue(8);
		System.out.println(queue.peekFront()); // 3
		System.out.println(queue.dequeue()); // 3
		System.out.println(queue.peekFront()); // 2
		queue.enqueue(9);
		queue.enqueue(11); // exception
	}

}