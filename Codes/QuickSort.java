/*********************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * Lecture 14 Advanced Sorting
 * Naive version of Quick Sort
 * 
 *********************************************************/
import java.util.Arrays;

public class QuickSort {
	private static final int SIZE = 10000;

	public static void quickSort(int[] data) {
		recQuickSort(data, 0, data.length - 1);
	}

	private static void recQuickSort(int[] data, int left, int right) {
		if (left >= right) // base case
			return;
		else {
			int pivot = data[right];
			// partition first and get the location of the pivot
			int partition = partition(data, left, right, pivot);
			// then perform recursive calls
			recQuickSort(data, left, partition - 1);
			recQuickSort(data, partition + 1, right);
		}
	}

	private static int partition(int[] data, int left, int right, int pivot) {
		int leftPointer = left - 1;
		int rightPointer = right;

		while (true) {
			// scanning to find out-of-place values
			while (data[++leftPointer] < pivot);
			while (rightPointer > 0 && data[--rightPointer] > pivot);

			if (leftPointer >= rightPointer) // nothing to swap
				break;
			else { // swap out-of-place values
				swap(data, leftPointer, rightPointer);
			}
		}
		// put pivot value into the right location
		swap(data, leftPointer, right);
		return leftPointer; // return where the pivot value is (index)
	}

	private static void swap(int[] data, int one, int two) {
		int tmp = data[one];
		data[one] = data[two];
		data[two] = tmp;
	}

	public static void main(String[] args) {
		int[] a = new int[SIZE];

		for (int i = 0; i < SIZE; i++)
			a[i] = (int) (Math.random() * SIZE);

		quickSort(a);

		int[] test = { 42, 12, 89, 27, 94, 63, 3, 78 };

		quickSort(test);
		System.out.println(Arrays.toString(test));

		// test partition
		int[] b = {42,89,63,12,94,27,78,3,50,36}; 
		int right = b.length-1; 
		int pivot = b[right]; 
		int pivotIndex = partition(b, 0, right, pivot);
		System.out.println(Arrays.toString(b));
		System.out.println(pivotIndex);
	}
}