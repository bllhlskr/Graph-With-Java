
public class Stack {    
   
	//Properties
	private int arr[];
	private int top;
	private int size;
	
	//Constructors
	Stack(int x) {
		arr = new int[x];
		size = x;
		top = -1;
	}
	
	//Getters and Setters
	public boolean isEmpty() {
		return top == -1;
	}
	public boolean isFull() {
		return top == size - 1;
	}
	public int getSize() {
		return size;
	}
	
	//Methods
	public void push(int x) {
		if(isFull()) {
			System.out.println("Stack is full");
		}
		else {
			arr[++top] = x;
		}
	}
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
			return -1;
		}
		else {
			return arr[top--];
		}
	}
	
} 
