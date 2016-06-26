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
