public class Stack { //create a Linkedlist
    private Node top; //private Node head
    //private Node bottom; but we dont need the tail cause we dont work with this
    private int height; //this is the length of the list and height in Stack
    class Node{
        int value;
        Node next;
        Node(int value){
            this.value=value;
        }
    }

public Stack(int value){
        Node newNode = new Node(value);
        top = newNode;
        height = 1;

}
public void printStack(){
    Node temp = top;
    while(temp!=null){
        System.out.println(temp.value);
        temp = temp.next;
    }
}

public void push(int value){
    Node newNode = new Node(value);
    if(height ==0){
        top=newNode;
    } else{
newNode.next=top;
top = newNode;
}

}

public Node pop(){
    if(height==0)return null;
     
Node temp = top;
top = top.next;
temp.next = null;
height--; 
return temp;
}


public void getTop(){
    if(top == null){
        System.out.println("Top is null");
    } else{
    System.out.println("Top is:  "+top.value);
    }
}
public void getHeight(){
    System.out.println("Height: " +height);

}

public static void main (String[]args){
    Stack myStack = new Stack(7);
    myStack.push(23);
    myStack.push(3);
    myStack.push(11);
    myStack.pop();
    myStack.printStack();
}



}
