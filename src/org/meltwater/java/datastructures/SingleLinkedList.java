package org.meltwater.java.datastructures;

public class SingleLinkedList<E> {
	
	class LinkedNode{
        private E content;
        private LinkedNode next;

        public LinkedNode(E content, LinkedNode next) {
            this.content = content;
            this.next = next;
        }
        
        public E getContent(){
        	return content;
        }
        
        public LinkedNode getNext(){
        	return next;
        }
    }
	
	private LinkedNode first, last, current;
	private int position ;
	
	public SingleLinkedList() {
        first = null;
        last = null;
        position = 0;
    }
	
	public void add(E element){
		if(isEmpty()){
			last = new LinkedNode(element, null);
            first = last;
		}
		else{
			 LinkedNode prev = last;
	         last = new LinkedNode(element, null);
	         prev.next = last;
		}
		position++;
	} 
	
	public void add(int pos, E element){
		// check if position is up to number
		if(pos < 0 || pos > position-1) throw new RuntimeException("index not valid");
		for (int i = 0; i<= pos-1; i++){
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
	
	public String toString(){
		StringBuilder returnedString = new StringBuilder();
		for (int i = 0; i<= position-1; i++){
			if (i == 0) 
				 current = first;
			 else
				 current = current.next;
			returnedString.append(current.content.toString()+ ", ");
		}
		return returnedString.toString();
	}
	
	
	public boolean isEmpty() {
        return position == 0;
    }
	
	public int size(){
		return position;
	}
	
	public LinkedNode head(){
		return this.first;
	}
	
	public LinkedNode tail(){
		return this.last;
	}
	
	
	
	

}
