public class BracketChecker {
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
