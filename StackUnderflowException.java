
public class StackUnderflowException extends Exception {
	public StackUnderflowException() {
		super("pop method called on an empty stack");
	}

}
