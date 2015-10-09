package org.meltwater.java.datastructures;

public class Set<E extends Comparable> {
	private BetterArray<E> set;

	/**
	 * Initialises an empty set.
	 */
	public Set() {
		set = new BetterArray<E>();
	}

	public void add(E element) {
		if (element == null)
			throw new NullPointerException("called add() with a null key");
		set.append(element);
	}

	public boolean contains(E element) {
		if (element == null)
			throw new NullPointerException("called contains() with a null key");
		return set.contains(element);
	}

	public void delete(E element) {
		if (element == null)
			throw new NullPointerException("called delete() with a null key");
		set.remove(element);
	}

	public int size() {
		return set.size();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public E max() {
		E maxElement = null;
		if (isEmpty())
			throw new RuntimeException("called max() with empty set");
		for (int k = 0; k <= size() - 1; k++) {
			if (set.get(k).compareTo((E) maxElement) >= 0)
				maxElement = set.get(k);
		}
		return maxElement;

	}

	public E min() {
		E minElement = null;
		if (isEmpty())
			throw new RuntimeException("called min() with empty set");
		for (int k = 0; k <= size() - 1; k++) {
			if (set.get(k).compareTo((E) minElement) <= 0)
				minElement = set.get(k);
		}
		return minElement;
	}

	public String toString() {
		StringBuilder returnedString = new StringBuilder();
		for (int i = 0; i <= size() - 1; i++) {
			returnedString.append(set.get(i).toString() + ", ");
		}
		return returnedString.toString();

	}

}
