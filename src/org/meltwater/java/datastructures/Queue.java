package org.meltwater.java.datastructures;

public class Queue<E extends Comparable> {

	E[] queueArray;
	private final int DEFAULT_STACK_SIZE = 10;
	private final int DEFAULT_NOT_FOUND = -1;
	private int position;

	private void remove(int index) {
		for (int i = index; i <= position - 1; i++) {
			queueArray[i] = queueArray[i + 1];
		}
		position--;
	}

	public Queue(int size) {
		queueArray = (E[]) (new Object[size]);
		position = 0;
	}

	public Queue() {
		this.queueArray = (E[]) (new Object[DEFAULT_STACK_SIZE]);
		this.position = 0;
	}

	public void enqueue(E element) {
		if (isFull())
			throw new RuntimeException("Stack overflow");
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

	public void deQueue() {
		if (isEmpty())
			throw new RuntimeException("Stack underflow");
		else
			remove(0);
	}

	public E peek() {
		return queueArray[0];
	}

	public boolean isFull() {
		if (position == queueArray.length - 1)
			return true;
		else
			return false;
	}

	public int contains(E element) {
		for (int k = 0; k <= position; k++) {
			if (queueArray[k].compareTo((E) element) == 0)
				return k;
		}
		return DEFAULT_NOT_FOUND;
	}

}
