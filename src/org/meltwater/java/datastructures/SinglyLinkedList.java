package org.meltwater.java.datastructures;

public class SinglyLinkedList<E> {

	class LinkedNode implements Comparable {
		private E content;
		private LinkedNode next;

		public LinkedNode(E content, LinkedNode next) {
			this.content = content;
			this.next = next;
		}

		public E getContent() {
			return content;
		}

		public LinkedNode getNext() {
			return next;
		}

		@Override
		public int compareTo(Object element) {
			final int BEFORE = -1;
			final int EQUAL = 0;
			final int AFTER = 1;
			E newObject = (E) element;
			if (this.content.equals(newObject))
				return EQUAL;

			return BEFORE;
		}

	}

	private LinkedNode first, last, current;
	private int position;

	private int getPosition(E element) {
		for (int i = 0; i <= position - 1; i++) {
			if (i == 0)
				current = first;
			else
				current = current.next;
			if (current.compareTo(element) == 0)
				return i;
		}
		return -1;
	}

	public SinglyLinkedList() {
		first = null;
		last = null;
		position = 0;

	}

	public void add(E element) {
		if (isEmpty()) {
			last = new LinkedNode(element, null);
			first = last;
		} else {
			LinkedNode prev = last;
			last = new LinkedNode(element, null);
			prev.next = last;
		}
		position++;
	}

	public void add(int pos, E element) {
		// check if position is up to number
		if (pos < 0 || pos > position - 1)
			throw new RuntimeException("index not valid");
		for (int i = 0; i <= pos - 1; i++) {
			if (i == 0)
				current = first;
			else
				current = current.next;
		}
		LinkedNode previous = current;
		current = current.next;
		LinkedNode newNode = new LinkedNode(element, current);
		previous.next = newNode;
		position++;
	}

	public void remove(E element) {
		for (int i = 0; i <= position - 1; i++) {
			LinkedNode pre = current;
			if (i == 0)
				current = first;
			else
				current = current.next;
			if (current.compareTo(element) == 0) {
				pre.next = current.next;
				position--;
				break;
			}
		}

	}

	public void insertBefore(E elem1, E elem2) {
		// Insert elem2 before elem1.
		int pos = getPosition(elem1);
		add(pos, elem2);
	}

	public void insertAfter(E elem1, E elem2) {
		// Insert elem2 after elem1.
		int pos = getPosition(elem1);
		add(pos + 1, elem2);
	}

	public boolean contains(E element) { // Returns true if element is in the
		int result = getPosition(element);
		if (result != -1)
			return true;
		return false;
	}

	public void reverse() {
		// LinkedNode pre, cur, nex;
		// pre = first;
		// while(true){
		// current = pre.next;
		// nex = current.next;
		// current.next = pre;
		// }
	}

	public String toString() {
		StringBuilder returnedString = new StringBuilder();
		for (int i = 0; i <= position - 1; i++) {
			if (i == 0)
				current = first;
			else
				current = current.next;
			returnedString.append(current.content.toString() + ", ");
		}
		return returnedString.toString();
	}

	public boolean isEmpty() {
		return position == 0;
	}

	public int size() {
		return position;
	}

	public LinkedNode head() {
		return this.first;
	}

	public LinkedNode tail() {
		return this.last;
	}

}
