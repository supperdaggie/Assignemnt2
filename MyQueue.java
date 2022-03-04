import java.util.ArrayList;

public class MyQueue<T> implements  QueueInterface{
	private int size;
	private ArrayList<T> queue;
	private int capacity;{

}
	public MyQueue(int capacity) {
		this.size = 0;
		this.capacity = capacity;
		queue = new ArrayList<T>(capacity);
		
	}

	@Override
	public boolean isEmpty() {
		if(size == 0) {
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
	public Object dequeue() throws QueueUnderflowException {
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		T data = this.queue.get(0);
		this.queue.remove(0);
		--this.size;
		
		return data;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean enqueue(Object e) throws QueueOverflowException {
		if(isFull()) {
			throw new QueueOverflowException();
		}
		T data = (T) e;
		queue.add(data);
		size++;
		
		return true;
	}
	@Override 
	public String toString() {
		String result = "";
		
		for(T s: queue) {
			result += (T)s;
		}
		
		return result;
	}

	@Override
	public String toString(String delimiter) {
		String result ="";
		
		for(int i = 0; i < size; i++) {
			if(i == size-1) {
				result += (T)queue.get(i);
				break;
			}
			result += (T)queue.get(i) + delimiter;
		}
		
		return result;
	}

	@Override
	public void fill(ArrayList list) {
		// TODO Auto-generated method stub
		ArrayList<T> copy = (ArrayList<T>) list.clone();
		
		for(T s: copy) {
			queue.add(s);
			++this.size;
		}
	}
}	

