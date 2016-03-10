/********************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * Lecture 8 Simple Sorting
 * Bubble Sort, Selection Sort, and Insertion Sort
 *
 ********************************************************/
import java.util.Arrays;

public class SimpleSorting {
	
	// O(n^2) and slow 
	public static void bubbleSort(int[] data) {
		// move backward from the last index to 1
		for(int out=data.length-1; out >= 1; out--) {
			// move forward from 0 to the right
			for(int in = 0; in < out; in++) {
				if(data[in] > data[in+1]) // if right value is smaller
					swap(data, in, in+1); // swap
			}
		}	
	}
	
	// O(n^2) faster than bubble sort because swap only happens in the outer loop
	public static void selectionSort(int[] data) {
		int min; // set min variable for tmp min value
		// move forward to right
		for(int out=0; out < data.length-1; out++) {
			min = out; // set initial min index to be out
			// move forward to right from out+1 to the end
			for(int in = out+1; in < data.length; in++) 
				if(data[in] < data[min]) // if data is smaller than current min value
					min = in; // set a new min index
			
			// swap min value with the first one as we move to the right
			// swap is happening within the outer loop
			swap(data, out, min); 
		}
	}
	
	/*
	 * O(n^2) fastest among the three because there is less number of comparisons 
	 * and uses shifting instead of swapping
	 */
	public static void insertionSort(int[] data) {
		// start from 1 till the last index
		for(int out=1; out < data.length; out++) {
			int tmp = data[out]; // save the first value as tmp
			int in = out; // initial in variable index
			// move backward till it finds the location to insert
			while(in > 0 && data[in-1] >= tmp) {
				// shift to right to make a room
				data[in] = data[in-1];
				in--;
			}
			// finally insert the tmp value to the right position
			data[in] = tmp;
		}
	}

	// helper method to swap two values in an array
	private static void swap(int[] data, int one, int two) {
		int tmp = data[one];
		data[one] = data[two];
		data[two] = tmp;
	}
 	
	// a few tests
	public static void main(String[] args) {
		int[] a = {4,7,2,5,3};
		bubbleSort(a);
		System.out.println(Arrays.toString(a));
		
		int[] b = {4,7,2,5,3};
		selectionSort(b);
		System.out.println(Arrays.toString(b));
		
		int[] c = {4,7,2,5,3};
		insertionSort(c);
		System.out.println(Arrays.toString(c));
	}

}
