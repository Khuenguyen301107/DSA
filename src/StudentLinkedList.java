public class StudentLinkedList { 
       private Node head;
       private Node tail;
       private int length;
       class Node {
        int StudentID;
        String StudentName;
        double GPA;
        Node next;
        Node (int StudentID, String StudentName, double GPA){
            this.StudentID= StudentID;
            this.StudentName = StudentName;
            this.GPA = GPA;
        }
       } 

    public StudentLinkedList (int StudentID, String StudentName, double GPA){
          Node newNode = new Node(StudentID, StudentName, GPA);
          head = newNode;
          tail = newNode;
          length = 1;
    }

    public void prepend(int StudentID, String StudentName, double GPA){
         Node newNode = new Node(StudentID, StudentName, GPA);
         if(length == 0){
            head = newNode; 
            tail = newNode;
         } else {
            Node temp = head;
            head = newNode; 
            newNode.next = temp;
         }
         length++;

    }

    public void append (int StudentID, String StudentName, double GPA){
        Node newNode = new Node (StudentID, StudentName, GPA);
        if(length == 0){
           head = newNode;
           tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void printList(){
        Node temp = head;
        while (temp != null ){
            System.out.print(temp.StudentID + " (" + temp.StudentName + ",  " + temp.GPA + ") -> ");
            temp = temp.next;
        }
        System.out.print("NULL");

    }

    public void search(int StudentID){
        Node temp = head;
        while (temp != null && temp.StudentID != StudentID){
           temp = temp.next;
        }
         if(temp != null){
                System.out.println(temp.StudentID + " (" + temp.StudentName + ",  " + temp.GPA + ")");
            } else {
            System.out.println("StudentID " + StudentID + " does not exist.");
            }
    }

   public void delete(int StudentID){
          Node temp = head;
          Node pre = null;
          while (temp != null){
            if (temp.StudentID == StudentID){
                if(temp == head){
                    head = head.next;
                    
                } else {
                    pre.next = temp.next;
                }
                if (temp == tail){
                    tail = tail.next;
                }
                length--;
            } else {
                pre = temp;
            }
            temp = temp.next;
          }
   }
  
   public void maxgpa(){
    if(length == 0) return ;
   Node temp = head;
   double maxGPA = head.GPA;
   while(temp != null){
    if(temp.GPA > maxGPA){
        maxGPA = temp.GPA;
    }
    temp = temp.next;
   }
   temp = head;
   while(temp != null){
       if(temp.GPA == maxGPA){
           System.out.println(temp.StudentID + " (" + temp.StudentName + ",  " + temp.GPA + ")");
       }
       temp = temp.next;
   }
   
   }
    public static void main(String[]args){
        StudentLinkedList myList = new StudentLinkedList(101, "Alice", 3.5 );
        myList.append(102,"Bob",3.8);
        myList.append(103,"Charlie",3.2);
        myList.prepend(104, "David", 3.9);
        myList.search(100);
        myList.delete(102);
        myList.maxgpa();
        myList.printList();

    }
}