/********************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * Lecture 14 Advanced Sorting
 * Naive version of Merge Sort
 * 
 *********************************************************/
import java.util.Arrays;

public class MergeSort {

	private static final int SIZE = 10000;

	public static int[] mergeSort(int[] data) {
		if (data.length <= 1) // base case
			return data;

		// divide into two
		// create left half
		int[] left = new int[data.length / 2];
		System.arraycopy(data, 0, left, 0, left.length);

		// create right half
		int[] right = new int[data.length - left.length];
		System.arraycopy(data, left.length, right, 0, right.length);

		// call itself to sort left half
		left = mergeSort(left);
		// call itself to sort right half
		right = mergeSort(right);

		// merge the sorted left and right and return
		return merge(left, right);
	}

	// Precondition: two input arrays are sorted.
	private static int[] merge(int[] left, int[] right) {
		// create a new array to hold merged elements
		int[] merged = new int[left.length + right.length];

		int index_left = 0, index_right = 0, index_m = 0;

		// traverse and put proper values into the merged array from left or
		// right array
		while (index_left < left.length && index_right < right.length) {
			if (left[index_left] < right[index_right])
				merged[index_m] = left[index_left++];
			else
				merged[index_m] = right[index_right++];

			index_m++;
		}

		// need to handle the case where elements are not all copied over to
		// the merged array
		if (index_left < left.length) { // elements are still in left array
			for (int i = index_left; i < left.length; i++)
				merged[index_m++] = left[i];
		} else { // elements are still in right array
			for (int i = index_right; i < right.length; i++)
				merged[index_m++] = right[i];
		}

		return merged;
	}

	public static void main(String[] args) {
		int[] a = new int[SIZE];
		for (int i = 0; i < SIZE; i++)
			a[i] = (int) (Math.random() * SIZE);

		mergeSort(a);

		int[] test = { 42, 12, 89, 27, 94, 63, 3, 78 };
		System.out.println(Arrays.toString(mergeSort(test)));

		// test merge method
		int[] left = { 12, 42, 63, 89 };
		int[] right = { 3, 27, 78, 94 };
		System.out.println(Arrays.toString(merge(left, right)));
	}

}