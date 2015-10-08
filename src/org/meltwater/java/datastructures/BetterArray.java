package org.meltwater.java.datastructures;

public class BetterArray<E extends Comparable> {
	
	
	// remember to work on the comparable functions

	private E[] array;
	private final int DEFAULT_ARRAY_SIZE = 10;
	private int size;

	private void copyArray(E[] copyFrom, E[] copyTo) {
		for (int i = 0; i <= copyFrom.length - 1; i++) {
			copyTo[i] = copyFrom[i];
		}
	}

	private void createAnotherArray() {
		int newSize = 2 * array.length;
		E[] newArray = (E[]) (new Object[newSize]);
		copyArray(array, newArray);
		array = newArray;
	}

	public BetterArray() {
		array = (E[]) (new Object[DEFAULT_ARRAY_SIZE]);
		this.size = 0;
	}

	public E get(int index) {
		if (index < 0 || index > size) {
			throw new RuntimeException("index not valid");
		} else {
			return array[index];
		}
	}

	public boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}

	public void insert(int position, E element) {
		if (isFull())
			createAnotherArray();

		E previous_temp = get(position);
		array[position] = element;
		for (int k = position + 1; k <= size; k++) {
			E current_temp = get(k);
			array[k] = previous_temp;
			previous_temp = current_temp;
		}
		size++;
	}

	public void append(E element) {
		insert(size, element);
	}

	public void remove(int index) {
		for (int i = index; i <= size - 1; i++) {
			array[i] = get(i + 1);
		}
		size--;
	}
	
	public void remove(E element){
		int index = index(element);
		remove(index);
	}

	public void shift(E element) {
		insert(0, element);
	}

	public boolean isFull() {
		if (size == array.length)
			return true;
		return false;

	}

	public int size() {
		return size;
	}

	public String toString() {
		StringBuilder returnString = new StringBuilder();
		for (int i = 0; i <= size - 1; i++) {
			returnString.append(get(i).toString() + ", ");
		}
		return returnString.toString();
	}

	public int index(E element) {
		for (int k = 0; k <= size - 1; k++) {
			if (get(k).compareTo(element) == 0)
				return k;
		}
		return -1;
	}

	public boolean contains(E element) {
		if (index(element) == 0)
			return true;
		return false;

	}

	public void reverse() {
		E temp_storage;
		int halfSize = (size / 2);
		for (int k = 0; k <= halfSize; k++) {
			temp_storage = array[k];
			array[k] = array[size - k - 1];
			array[size - k - 1] = temp_storage;
		}

	}

}
