/********************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * Lecture 5 LinkedList
 * Simple Singly Linked List Implementation
 *
 ********************************************************/

import java.util.*;

public class SinglyLinkedList<AnyType> implements Iterable<AnyType>{
	
	private Node<AnyType> head;
	
	/**
	 * construct an empty linkedlist
	 */
	public SinglyLinkedList() {
		head = null;
	}
	
	/**
	 * add a new element at the beginning of the list
	 * @param item a new item to add
	 */
	public void addFirst(AnyType item) {
		head = new Node<AnyType>(item, head);
	}
	
	/**
	 * add a new element to the end of the list
	 * @param item a new item to add
	 */
	public void addLast(AnyType item) {
		if(head==null)
			addFirst(item);
		else {
			// traverse first to get to the last node
			Node<AnyType> tmp = head;
			while(tmp.next != null) 
				tmp = tmp.next;
			
			tmp.next = new Node<AnyType>(item,null);
		}
	}
	
	/**
	 * find key item from the list and add a new item after that
	 * @param key a key item to search for
	 * @param toInsert a new item to add
	 */
	public void insertAfter(AnyType key, AnyType toInsert) {
		// find the key item from the list first
		Node<AnyType> tmp = head;
		while(tmp != null && !tmp.data.equals(key))
			tmp = tmp.next;
		
		// if the key item is found, then add the new item
		if(tmp != null)
			tmp.next = new Node<AnyType>(toInsert, tmp.next);
	}
	
	/**
	 * find key item from the list and add a new item before it
	 * @param key a key item to search for
	 * @param toInsert a new item to add
	 */
	public void insertBefore(AnyType key, AnyType toInsert) {
		// if the list is empty, nothing to do
		if(head == null) return;
		
		// if head has the key data, then reuse addFirst
		if(head.data.equals(key)) {
			addFirst(toInsert);
			return;
		}
		
		/*
		 * traverse to find key item
		 * but keeping track of prev and curr node references
		 */
		Node<AnyType> prev = null;
		Node<AnyType> curr = head;
		
		while(curr != null && !curr.data.equals(key)){
			prev = curr;
			curr = curr.next;
		}
		
		// if the key item is found, then add the new item using the prev and curr references
		if(curr != null)
			prev.next = new Node<AnyType>(toInsert, curr);
	}
	
	/**
	 * Delete the first occurrence of the key item
	 * @param key a key item to search for and remove when found
	 */
	public void remove(AnyType key) {
		// empty list
		if(head == null) return;
		
		// if the head is the one to remove
		if(head.data.equals(key)) {
			head = head.next;
			return;
		}
		
		/*
		 * traverse to find key item
		 * but keeping track of prev and curr references
		 */
		Node<AnyType> prev = null;
		Node<AnyType> curr = head;
		
		while(curr!=null && !curr.data.equals(key)) {
			prev = curr;
			curr = curr.next;
		}
		
		// not found
		if(curr == null) return;
		
		// found
		prev.next = curr.next;
	}
	
	/**
	 * return list iterator instance 
	 */
	@Override
	public Iterator<AnyType> iterator() {
		return new SinglyLinkedListIterator();
	}
	
	/*
	 * inner class for linkedlist iterator
	 * this implements Iterator interface
	 */
	private class SinglyLinkedListIterator implements Iterator<AnyType> {

		private Node<AnyType> nextNode;
		
		public SinglyLinkedListIterator() {
			nextNode = head;
		}
		
		@Override
		public boolean hasNext() {
			return nextNode!=null;
		}

		@Override
		public AnyType next() {
			if(!hasNext()) throw new NoSuchElementException();
			AnyType result = nextNode.data;
			nextNode = nextNode.next;
			return result;
		}

		// do not want to remove while iterating
		@Override
		public void remove() {
			throw new UnsupportedOperationException();		
		}
		
	}
	
	/*
	 * static nested class Node (data object and reference to next node)
	 * used only in this class 
	 */
	private static class Node<AnyType> {
		private AnyType data;
		private Node<AnyType> next;
		
		public Node(AnyType data, Node<AnyType> next) {
			this.data = data;
			this.next = next;
		}
	}

}