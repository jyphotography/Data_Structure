/******************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * Lecture 6 Stack 
 * Simple String Reverse Example
 *
 ******************************************************/

import java.io.*;

public class ReverseApp {
	
	public static void main(String[] args) throws IOException {
		String input;
		while(true) {
			System.out.print("Enter a string: ");
			System.out.flush();
			
			input = getString();
			if(input.equals("")) 
				break;
			
			Reverser theReverser = new Reverser(input);
			System.out.println("Reversed: "+theReverser.doReverse());
		}

	}
	
	private static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		return br.readLine();
	}
	
}