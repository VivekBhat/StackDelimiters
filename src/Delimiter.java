import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;

class StackX {
	int max;
	int top;
	char[] arr;

	public StackX(int max) {
		this.max = max;
		top = -1;
		arr = new char[this.max];
	}

	public void push(char something) {
		arr[++top] = something;
	}

	public char pop() {
		return arr[top--];
	}

	public char peek() {
		return arr[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}
}

class BracketChecker {
	public String inputChecker;

	public BracketChecker(String inp) {
		inputChecker = inp;
	}

	public void check() {
		int stacksize = inputChecker.length();
		StackX stack = new StackX(stacksize);

		for (int i = 0; i < stacksize; i++) {
			char ch = inputChecker.charAt(i);
			switch (ch) {
			case '{':
			case '(':
			case '[':
				stack.push(ch);
				break;

			case '}':
			case ')':
			case ']':
				if (!stack.isEmpty()) {
					char chx = stack.pop();
					if ((ch == '}' && chx != '{') || (ch == ']' && chx != '[')
							|| (ch == ')' && chx != '('))
						System.out.println("Error: " + ch + " at " + i);
				}

				else
					// prematurely empty
					System.out.println("Error: " + ch + " at " + i);
				break;

			default:
				break;
			}
		}
		if (!stack.isEmpty())
			System.out.println("Error: missing right delimiter");
	}
}

class Delimiter {

	public static void main(String[] args) throws IOException {
		String input;
		while (true) {
			System.out.println("Enter String containing delimiters: ");

			System.out.flush();

			input = getString();
			if (input.equals(" ")) {
				break;
			} else {
				BracketChecker theChecker = new BracketChecker(input);
				theChecker.check();
			}
		}
	}

	public static String getString() throws IOException {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(in);
		String s = buff.readLine();
		return s;
	}
}
