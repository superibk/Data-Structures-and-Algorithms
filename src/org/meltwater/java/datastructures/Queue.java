package org.meltwater.java.datastructures;

public class Queue<E extends Comparable> {
	
	E[] queueArray;
	private final int DEFAULT_STACK_SIZE = 10;
	private final int DEFAULT_NOT_FOUND = -1;
	private int position;

	

	public Queue(int size) {
		queueArray = (E[]) (new Object[size]);
		position = 0;
	}

	public Queue() {
		this.queueArray = (E[]) (new Object[DEFAULT_STACK_SIZE]);
		this.position = 0;
	}

	public void enqueue(E element) {
		if (isFull()) throw new RuntimeException("Stack overflow");
		queueArray[position++] = element;
	}

	public boolean isEmpty() {
		if (position == 0)
			return true;
		else
			return false;
	}

	public int size() {
		return position;
	}

	public E deQueue() {
		if (isEmpty())
			throw new RuntimeException("Stack underflow");
		else
			return queueArray[position--]; // return the saved item
	}

	public E peek() {
		if (isEmpty())
			throw new RuntimeException("Stack underflow");
		else
			return queueArray[position-1];
	}

	public boolean isFull() {
		if (position == queueArray.length - 1)
			return true;
		else
			return false;
	}
	
	public int contains(E element){
		for (int k=0 ; k<= position; k++ ){
			if(queueArray[k].compareTo((E)element) == 0)
				return k;
		}
		return DEFAULT_NOT_FOUND;
	}

	

}
