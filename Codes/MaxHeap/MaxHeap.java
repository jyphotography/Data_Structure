/********************************************************
 * 
 * 95-772 Data Structures for Application Programmers 
 * Lecture 18 Heaps and Heap Sort
 * 
 * A very simple and naive MaxHeap implementation
 * 
 ********************************************************/

public class MaxHeap implements MaxHeapInterface {

	private Node[] heapArray;
	private int currentSize;

	// precondition : initialSize > 0
	public MaxHeap(int initialSize) {
		heapArray = new Node[initialSize];
		currentSize = 0;
	}

	/**
	 * Insert a new value into a heap
	 * 
	 * @param value
	 *            value to be inserted
	 * @return boolean to check whether it was added or not
	 */
	@Override
	public boolean insert(double value) {
		if (currentSize == heapArray.length) // array is full
			return false;
		Node newNode = new Node(value);
		// insert into the next available index position
		// to make sure the heap is complete
		heapArray[currentSize] = newNode;
		percolateUp(currentSize++);
		return true;
	}

	/**
	 * remove maximum value
	 * 
	 * @return Max value that is removed from the heap
	 */
	@Override
	public double removeMax() {
		Node root = heapArray[0];
		// massive promotion of the last node to the root
		// to make sure the heap is complete
		heapArray[0] = heapArray[--currentSize];
		percolateDown(0);
		return root.value;
	}

	public int size() {
		return currentSize;
	}

	// helper method to percolate up for insert operation
	private void percolateUp(int index) {
		Node bottom = heapArray[index];
		int parent = (index - 1) / 2;

		// compare with parent and move it down if necessary
		while (index > 0 && heapArray[parent].value < bottom.value) {
			heapArray[index] = heapArray[parent]; // move node down
			index = parent; // move index upward
			parent = (parent - 1) / 2; // parent also moves upward
		}
		heapArray[index] = bottom;
	}

	// helper method to percolate down for remove max operation
	private void percolateDown(int index) {
		Node top = heapArray[index];
		// need to keep track of larger child
		int largerChild;

		// loop as long as there is left child
		while (index < currentSize / 2) {
			int leftChild = index * 2 + 1;
			int rightChild = leftChild + 1;

			if (rightChild < currentSize
					&& heapArray[leftChild].value < heapArray[rightChild].value)
				largerChild = rightChild;
			else
				largerChild = leftChild;

			if (top.value >= heapArray[largerChild].value)
				break;

			heapArray[index] = heapArray[largerChild];
			index = largerChild;
		}

		heapArray[index] = top;
	}

	/*
	 * private static class for Node 
	 * No left and right self-references needed
	 */
	private static class Node {
		private double value;

		public Node(double value) {
			this.value = value;
		}
	}

}