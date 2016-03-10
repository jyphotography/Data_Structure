/******************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * Lecture 6 Stack 
 * Simple String Reverser
 *
 ******************************************************/

public class Reverser {
	private String input;
	
	public Reverser(String input) {
		this.input = input;
	}
	
	public String doReverse() {
		ArrayStack<Character> theStack = new ArrayStack<Character>(input.length());
		for(int i=0; i < input.length(); i++)
			theStack.push(input.charAt(i));
		
		StringBuffer output = new StringBuffer();
		while(!theStack.isEmpty())
			output.append(theStack.pop());
		
		return output.toString();
		
		/* an option but slower
		String output = "";
		while(!stack.isEmpty()) 
			output = output + stack.pop();
			
		return output;
		*/
	}
}
