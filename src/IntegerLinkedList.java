public class IntegerLinkedList {
       private Node head;
       private Node tail;
       private int length;

       class Node {
         int value;
         Node next;
         Node (int value){
            this.value = value;
         }
       }

       public IntegerLinkedList (int value){
         Node newNode = new Node (value);
         head = newNode;
         tail = newNode;
         length = 1;
       }

       public void append (int value){
         Node newNode = new Node(value);
         if(length == 0){
            head = newNode;
            tail = newNode;
         } else {
            tail.next = newNode;
            tail = tail.next;
         }
         length++;
       }

       public void printList(){
         Node temp = head;
         while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
         }
         System.out.print("NULL");
       }

       public void insertAfter (int x, int y){
            Node temp = head;
            while(temp != null && temp.value != x){
               temp = temp.next;
            }
            if(temp != null){
               Node newNode = new Node(y);
               newNode.next= temp.next;
               temp.next = newNode;
               if(temp == tail){
                  tail = tail.next;
               }
               length++;

            }
       }

       public void deleteAll(int x){
              Node temp = head;
              Node before = null;
              while(temp != null){
               if(temp.value == x){
                  if(temp == head){
                     head = head.next;
                  } else {
                     before.next = temp.next;
                  }
                  if(temp == tail){
                     tail = before;
                  }
                  length--;
               }else{
                  before = temp;
               }
               temp = temp.next;
               
              }
       }

      public void reverse(){
            Node before = null;
            Node temp = head;
            head = tail;
            tail = temp;
            Node after = temp.next;
            for(int i =0 ; i<length; i++){
                after = temp.next;
                temp.next = before;
                before = temp;
                temp = after;
            }
      }
           

      
        public void removeDuplicate(){
            Node current = head;
            while(current != null){
               Node runner = head;
               while(runner.next != null){ // reach the end of the list
                     if(runner.next.value == current.value){
                        if (runner.next == tail){
                           tail = runner;
                        }
                        runner.next = runner.next.next;
                        length--;
                     } else {
                        runner = runner.next;
                     }
                     
                  }
                  current = current.next;
            }
      }

      public Node findMiddleNode(){
            Node slow = head;
            Node fast = head;
            while(fast != null && fast.next != null){
               slow = slow.next;
               fast = fast.next.next;

            }
            if(slow != null){
               System.out.println("Middle element: " + slow.value);
            }
            return slow;
      }
















      public static void main(String[] args){
         IntegerLinkedList myLinkedList = new IntegerLinkedList(10);
         myLinkedList.append(20);
         myLinkedList.append(30);
         myLinkedList.append(20);
         myLinkedList.append(40);
         myLinkedList.append(50);
         myLinkedList.insertAfter(20, 25);
         myLinkedList.deleteAll(20);
         myLinkedList.reverse();
         myLinkedList.findMiddleNode();

         myLinkedList.printList();

      }
}