/********************************************************
 * 
 * 95-772 Data Structures for Application Programmers 
 * Lecture 10 Recursion
 * Examples used in lecture
 * 
 ********************************************************/

public class MainDriver {

	public static int sum(int n) {
		int result = 0;
		for (int i = 1; i <= n; i++)
			result = result + i;
		return result;
	}

	public static int recSum(int n) {
		if (n == 1)
			return n;
		return n + recSum(n - 1);
	}

	public static int fib(int n) {
		if (n == 0 || n == 1)
			return n;
		else
			return fib(n - 1) + fib(n - 2);
	}

	public static int binarySearch(int[] data, int key) {
		int lowerBound = 0;
		int upperBound = data.length - 1;
		int mid;

		while (true) {
			if (lowerBound > upperBound)
				return -1;
			mid = lowerBound + (upperBound - lowerBound) / 2;
			if (data[mid] == key)
				return mid;
			else {
				if (data[mid] < key)
					lowerBound = mid + 1;
				else
					upperBound = mid - 1;
			}
		}
	}

	public static int binarySearch2(int[] data, int key) {
		return recBinarySearch(data, key, 0, data.length - 1);
	}

	private static int recBinarySearch(int[] data, int key, int lowerBound,
			int upperBound) {
		if (lowerBound > upperBound)
			return -1;
		int mid = lowerBound + (upperBound - lowerBound) / 2;
		if (data[mid] == key)
			return mid;
		else {
			if (data[mid] < key)
				return recBinarySearch(data, key, mid + 1, upperBound);
			else
				return recBinarySearch(data, key, lowerBound, mid - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(sum(5));
		System.out.println("recursive sum: " + recSum(5));
		System.out.println("fibonacci number: " + fib(5));
		System.out.println("fibonacci number: " + fib(2));
		System.out.println("fibonacci number: " + fib(7));

		int[] data = { 1, 2, 3, 4, 5 };
		System.out.println(binarySearch(data, 2));
		System.out.println(binarySearch2(data, 2));
	}
}
