/******************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * Lecture 6 Stack 
 * Simple Stack implementation with an array
 *
 ******************************************************/

public class ArrayStack<AnyType> implements StackInterface<AnyType> {
	
	private static final int DEFAULT_CAPACITY = 10;
	private AnyType[] array;
	private int top;
	
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * construct a new stack with initial capacity
	 * @param initialCapacity an initial length of the stack
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack(int initialCapacity) {
		if(initialCapacity <= 0)
			array = (AnyType[]) new Object[DEFAULT_CAPACITY];	
		else 
			array = (AnyType[]) new Object[initialCapacity];
		top = -1;
	}
	
	/**
	 * add a new element onto the top of the stack
	 */
	@Override
	public void push(AnyType e) {
		if(top == array.length-1)
			throw new StackException("Stack is full");
		array[++top] = e;	
	}

	/**
	 * get and delete (pop) an element from the top of the stack
	 */
	@Override
	public AnyType pop() {
		if(isEmpty()) 
			return null;
		
		AnyType e = array[top];
		array[top] = null;
		top--;
 		return e;
	}

	/**
	 * get (peek) the top element. Does not delete it!
	 */
	@Override
	public AnyType peek() {
		if(isEmpty()) 
			throw new StackException("Stack is full");
		return array[top];
	}

	/**
	 * check if the stack is empty or not
	 */
	@Override
	public boolean isEmpty() {
		return top == -1;
	}

}

@SuppressWarnings("serial")
class StackException extends RuntimeException {
	public StackException(String message) {
		super(message);
	}
	
	public StackException() {
		super();
	}
}
