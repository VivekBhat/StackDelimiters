import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;
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
