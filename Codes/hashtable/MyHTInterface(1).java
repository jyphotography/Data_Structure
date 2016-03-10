/********************************************************
 * 
 * 95-772 Data Structures for Application Programmers 
 * Lecture 12 HashTable Implementation (linear probing) 
 * 
 * This HashTable interface takes only positive integers
 * 
 ********************************************************/

public interface MyHTInterface {

	/**
	 * Returns true when the key is found
	 * 
	 * @param key
	 *            int key value to be searched
	 * @return boolean true if found, false not found
	 */
	boolean search(int key);

	/**
	 * Inserts a new positive int value to the table
	 * 
	 * @param value
	 *            int value to be inserted
	 */
	void insert(int value);

	/**
	 * Deletes and returns an int value from the table
	 * 
	 * @param key
	 *            int value to be deleted
	 * @return the deleted int value (if not found, -1)
	 */
	int delete(int key);
}