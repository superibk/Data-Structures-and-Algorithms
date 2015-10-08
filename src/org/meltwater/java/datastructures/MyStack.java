package org.meltwater.java.datastructures;

public class MyStack<E extends Comparable> {

	E[] stackArray;
	private final int DEFAULT_STACK_SIZE = 10;
	private final int DEFAULT_NOT_FOUND = -1;
	private int position;

	public MyStack(int size) {
		stackArray = (E[]) (new Object[size]);
		position = 0;
	}

	public MyStack() {
		this.stackArray = (E[]) (new Object[DEFAULT_STACK_SIZE]);
		this.position = 0;
	}

	public void push(E element) {
		if (isFull())
			throw new RuntimeException("Stack overflow");
		stackArray[position++] = element;
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

	public E pop() {
		if (isEmpty())
			throw new RuntimeException("Stack underflow");
		else
			return stackArray[position--]; // return the saved item
	}

	public E peek() {
		if (isEmpty())
			throw new RuntimeException("Stack underflow");
		else
			return stackArray[position - 1];
	}

	public boolean isFull() {
		if (position == stackArray.length - 1)
			return true;
		else
			return false;
	}

	public int contains(E element) {
		for (int k = 0; k <= position; k++) {
			if (stackArray[k].compareTo((E) element) == 0)
				return k;
		}
		return DEFAULT_NOT_FOUND;
	}

}
