import java.util.ArrayList;

public class MyStack<T> implements StackInterface {
	
	private int size;
	private int capacity;
	private ArrayList<T> stack;
	
	public MyStack(int capacity){
		this.size = 0;
		this.capacity = capacity;
		this.stack = new ArrayList<T>(capacity);
	}
	@Override
	public boolean isEmpty() {
		
		if(this.size==0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {

		if(this.size == capacity) {
			return true;
		}
		return false;
	}

	@Override
	public Object pop() throws StackUnderflowException {
		T data = null;
		
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
	
		for(int i = 0; i < size; i++) {
			//top of stack
			if(i==size-1) {
				data = stack.get(i);
				this.stack.remove(i);
				--this.size;
			}
		}
		return data;
	}

	@Override
	public Object top() throws StackUnderflowException {
		T data = null;
		
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		for(int i = 0; i< size; i++) {
			//top of stack
			if(i==size-1) {
				data = (T)stack.get(i);
			}
		}
		return data;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean push(Object e) throws StackOverflowException {
		if(isFull()) {
			throw new StackOverflowException();
		}
		stack.add((T) e);
		++this.size;
		return true;
	}
	
	@Override 
	public String toString() {
		String result = "";
		
		for(T s: stack) {
			result += (T)s;
		}
		
		return result;
	}

	@Override
	public String toString(String delimiter) {
		String result ="";
		
		for(int i = 0; i < size; i++) {
			if(i == size-1) {
				result += (T)stack.get(i);
				break;
			}
			result += (T)stack.get(i) + delimiter;
		}
		
		return result;
	}

	@Override
	public void fill(ArrayList list) {
		// TODO Auto-generated method stub
		ArrayList<T> copy = (ArrayList<T>) list.clone();
		
		for(T s: copy) {
			stack.add(s);
			++this.size;
		}
		
	}
}
