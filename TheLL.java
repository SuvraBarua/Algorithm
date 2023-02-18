import java.util.NoSuchElementException;

public class TheLL <T> {
	Node head;
	private int size;
	TheLL(){
		this.size = 0;
	}
	
	class Node {
		T s;
		Node next;
		
		Node(T s){
			this.s = s;
			this.next = null;
			size++;
		}
	}
	//adding elements in the head:-
	
	public void addFirst(T s) {
		Node node = new Node(s);
		
		if(head == null) {
			head = node;
			return;
		}
		
		node.next = head;
		head = node;
	}
	
	//adding elements in the last:-
	
	public void addLast(T s) {
		Node node = new Node(s);
		
		if(head == null) {
			head = node;
			return;
		}
		
		Node currNode = head;
		while (currNode.next != null) {
			currNode = currNode.next;
		}
		currNode.next = node;
	}
	//Printing all the elements:-
	
	public void print() {
		if(head == null) {
			return;
		}
		Node currNode = head;
		
		while(currNode != null) {
			System.out.print(currNode.s + "->");
			currNode = currNode.next;
		}
		System.out.print("null");
	}
	
	//Deletes the first item:-
	public void deleteFirst() {
		if(head == null) {
			System.out.println("There is no element");
			throw new NoSuchElementException();
		}
		size--;
		head = head.next;
	}
	
	//Deletes the last item:-
	public void deleteLast() {
		if(head == null) {
			System.out.println("No Elements");
			throw new NoSuchElementException();
		}
		size--;
		if(head.next == null) {
			head = null;
		}
		
		Node currNode = head; 
		Node secCurrNode = head;
		
		while(currNode.next != null) {
			secCurrNode = currNode;
			currNode = currNode.next;
		}
		secCurrNode.next = null;
	}
	public int getSize() {
		return size;
	}
    public void get(int index){
        if(head == null){
            System.out.println("Index doesn't Exists");
        }
        Node currNode = head;
        if(index <0){
            System.out.println("Inter a valid index number");
            return;
        }
        index--;
        while(index >= 0 ){
            currNode = currNode.next;
            index--;
        }
        System.out.println(currNode.s);
    }

    public boolean contains(T data){
        Node currNode = head;
        if(currNode == null){
            return false;
        }
        while(currNode != null){
            if(currNode.s == data){
                return true;
            }
            currNode = currNode.next;
        }
        return false;
    }
}
