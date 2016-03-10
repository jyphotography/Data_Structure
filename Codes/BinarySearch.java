/*****************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * Binary Search Implementation
 *
 *****************************************************/

public class BinarySearch {

	public static void main(String[] args) {
		int[] data = {1,2,3,4,5,6,7,8,9};
		System.out.println(binarySearch(data, 6));
	}
	
	public static int binarySearch(int[] data, int key) {
		int lowerBound = 0;
		int upperBound = data.length-1;
		int mid;
		
		while(true) {
			if(lowerBound > upperBound) return -1;
			
			mid = lowerBound + (upperBound - lowerBound)/2;
			if(data[mid] == key) return mid;
			else {
				if(data[mid] < key)
					lowerBound = mid+1;
				else
					upperBound = mid-1;
			}
		}
	}

}