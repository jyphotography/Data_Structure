/*****************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * Lecture 6 Stack 
 * A very simple Stack Interface
 *
 *****************************************************/

public interface StackInterface<AnyType> {
	
	/**
	 * pushes a new element onto the top of the stack in O(1)
	 * @param e a new element to add
	 * @throws StackException if it is full
	 */
	void push(AnyType e);
	
    /**
     * gets and removes the element on the top in O(1)
     * @return Top element or null when empty
     */
	AnyType pop();
	
    /**
     * gets the top element but does not delete it in O(1)
     * @return Top element or null when empty
     */
	AnyType peek();
	
    /**
     * checks if the stack is empty or not in O(1)
     * @return true if it is empty, false if it is not empty
     */
	boolean isEmpty();
}
