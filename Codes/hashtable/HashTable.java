/*************************************************************
 * 
 * 95-772 Data Structures for Application Programmers 
 * Lecture 12 HashTable Implementation 
 * Assumption: It takes only positive integers
 * 
 * A Very Simple and Naive HashTable with linear probing. 
 * This code is just to show the basic concept and logic.
 * 
 * In reality, there would be a lot more to think about, 
 * especially with the situation of rehashing
 * 
 *************************************************************/

public class HashTable implements MyHTInterface {
	private DataItem[] hashArray;
	private int arraySize;
	private DataItem nonItem;

	public HashTable(int size) {
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1); // a flag DateItem to mark deleted spot
	}

	/**
	 * Returns true when the key is found
	 * 
	 * @param key
	 *            int key value to be searched
	 * @return boolean value true if found, false not found
	 */
	@Override
	public boolean search(int key) {
		int hashVal = hashFunc(key);

		// loop through as long as it is not empty
		while (hashArray[hashVal] != null) {
			// found
			if (hashArray[hashVal].data == key)
				return true;
			// linear probing (step size is 1)
			hashVal++;
			hashVal = hashVal % arraySize; // wrap around
		}

		return false; // not found
	}

	/**
	 * Inserts a new positive int value to the table
	 * 
	 * @param value
	 *            int value to be inserted
	 */
	@Override
	public void insert(int value) {
		DataItem newItem = new DataItem(value);
		int hashVal = hashFunc(value);

		// loop through till it finds either empty or flagged cell
		while (hashArray[hashVal] != null && hashArray[hashVal].data != -1) {
			hashVal++;
			hashVal = hashVal % arraySize;
		}

		hashArray[hashVal] = newItem;
	}

	/**
	 * Deletes and returns an int value from the table
	 * 
	 * @param key
	 *            int value to be deleted
	 * @return the deleted int value. "-1" indicates that the key is not in the
	 *         table
	 */
	@Override
	public int delete(int key) {
		int hashVal = hashFunc(key);

		// loop through as long as it is not empty
		while (hashArray[hashVal] != null) {
			// found
			if (hashArray[hashVal].data == key) {
				DataItem tmp = hashArray[hashVal];
				hashArray[hashVal] = nonItem; // set the flag
				return tmp.data;
			}
			hashVal++; // step size is 1
			hashVal = hashVal % arraySize; // wrap around
		}

		return -1; // not found
	}

	private int hashFunc(int key) {
		return key % arraySize;
	}

	private static class DataItem {
		int data;

		DataItem(int data) {
			this.data = data;
		}
	}

}