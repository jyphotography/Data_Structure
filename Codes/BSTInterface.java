/********************************************************
 * 
 * 95-772 Data Structures for Application Programmers 
 * Lecture 15 Binary Trees, mainly Binary Search Trees 
 * 
 * Binary Search Tree interface
 * 
 ********************************************************/

public interface BSTInterface {

	/**
	 * search a value in the tree
	 * 
	 * @param key
	 *            key value to search
	 * @return boolean value indication success or failure
	 */
	boolean find(int key);

	/**
	 * insert a new element into the tree
	 * 
	 * @param key
	 *            key of the element
	 * @param value
	 *            value of the element
	 */
	void insert(int key, double value);

	/**
	 * delete an element from the tree using key
	 * 
	 * @param key
	 *            key of the element to be deleted
	 */
	void delete(int key);

	/**
	 * traverse the tree and print values of the tree
	 */
	void traverse();

}