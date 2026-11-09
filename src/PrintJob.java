import java.util.Scanner;

public class PrintJob {
    static class PrinterJob{
        private int jobId;
        private String userName;
        private String documentName;
        private int pages;

    public PrinterJob(int jobId, String userName, String documentName, int pages){
        this.jobId = jobId;
        this.userName = userName;
        this.documentName = documentName;
        this.pages = pages; 
    }

    public int getjobId(){
        return jobId;
    }

    public void setjobId(int jobId){
        this.jobId = jobId;
    }

    public String getuserName(){
        return userName;
    }
    public void setuserName(String userName){
         this.userName = userName;
    }

    public String getdocumentName(){
        return documentName;
    }

    public void setdocumentName(String documentName){
         this.documentName = documentName;
        
    }

    public int getpages(){
        return pages;
    }

    public void setpages(int pages){
        this.pages = pages;
    }

    public String toString(){
        return jobId + " - " + userName + " - " + documentName + " - " + pages;
    }

    }

    static class Node{
         PrinterJob job;
         Node next;
         Node(PrinterJob job){
            this.job = job;
            
         }
        }


    static class PrinterQueue {
        private Node front;
        private Node rear;
        private int length;
        private int size;
 public PrinterQueue() {
            this.front = null;
            this.rear = null;
            this.length = 0;
        }
    

    public void enqueue(PrinterJob job){
         Node temp = front;
         while(temp != null){
            if( temp.job.getjobId() == job.getjobId() ){
                System.out.println("Error! The JobId already exists!");
                return;
            }
            temp = temp.next;
         }
if(job.getpages()<0){
    System.out.println("Error: Pages must be greater than 0!");
    return;
}

Node newNode = new Node(job);
if(length == 0){
    front = newNode;
    rear = newNode;
} else {
    rear = rear.next;
    rear = newNode;
}
length++;
System.out.println("Print job enqueued successfully!");
    }

    public PrinterJob dequeue(){
        Node temp = front;
        if(isEmpty()) return null;
        if(length == 1){
            front = null;
            rear = null;
        } else {
            front = front.next;
            temp.next = null;
            
        }
        System.out.println("Print job dequeued successfully");
        length--;
        return temp.job;
    }

    public PrinterJob peek(){
        Node temp = front;
        if(isEmpty()){
            System.out.println(" There's no job.");
            return null;
        }
         System.out.println(" The first job is: ");
     return front.job;
    }

    public boolean isEmpty(){
          return front == null;
    }

    public int size(){
        return length;
    }

    public void display(){
        Node temp = front;
        if(isEmpty()){
            System.out.println("No pending print jobs.");
            return;
        }
       while(temp != null){
        System.out.println(temp.job);
        temp = temp.next;

       }
        System.out.println("Total pending jobs: " + size);
        System.out.println("Total pages waiting: " + totalPages());
    }

    public int totalPages(){
        int sum = 0;
        Node temp = front;
        while(temp != null){
            sum = sum + temp.job.getpages();
            temp = temp.next;
        }
        return sum;

    }

    public PrinterJob search(int jobId) {
          if(isEmpty()) return null;
          Node temp = front;
          while(temp != null ){
            if(temp.job.getjobId() == jobId){
                System.out.println("JobId has been found!");
                return temp.job;
            }
            temp = temp.next;
          }
          return null;
    }
  }

  public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       PrinterQueue queue = new PrinterQueue();
       System.out.println("\n========= PRINTER JOB MANAGEMENT ==========");
            System.out.println("1. Submit a new print job");
            System.out.println("2. Process the next print job");
            System.out.println("3. View the next print job");
            System.out.println("4. Display all pending print jobs");
            System.out.println("5. Search for a print job");
            System.out.println("6. Count pending print jobs");
            System.out.println("7. Calculate total pages waiting");
            System.out.println("0. Exit");
            System.out.println("===========================================");

while(true){
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch(choice){
            case 1: 
            System.out.print("Enter job ID: ");
            int jobId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter username: ");
            String userName= scanner.nextLine();
            System.out.print("Enter Document name: ");
            String documentName = scanner.nextLine();
            System.out.print("Enter pages (>0): ");
            int pages = scanner.nextInt();
            scanner.nextLine();

            PrinterJob newJob = new PrinterJob(jobId, userName, documentName, pages);
            queue.enqueue(newJob);
            break;

            case 2:
                PrinterJob processsed = queue.dequeue();
                if(processsed != null){
                    System.out.println("Processing next print job...");
                    System.out.println("Printing job  " + processsed.getjobId() + ": " + processsed.getdocumentName() + " (" + processsed.getpages() + " pages)");
                    System.out.println("Print job completed successfully.");
                    
                }
                break;

            case 3:
                PrinterJob nextJob = queue.peek();
                    if (nextJob != null) {
                        System.out.println("Next print job: " + nextJob);
                    }
                    break;
            case 4:
                queue.display();
                    break;
            case 5:
                System.out.print("Enter Job ID to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();

                    PrinterJob found = queue.search(searchId);
                    if (found != null) {
                        System.out.println("Print job found: " + found);
                    } else {
                        System.out.println("Print job with ID " + searchId + " not found.");
                    }
                    break;
            case 6:
                System.out.println("Total pending jobs: " + queue.size());
                    break;
            case 7:
                System.out.println("Total pages waiting: " + queue.totalPages());
                    break;
            case 0:
                System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;
            default: 
            System.out.println("Invalid choice! Please choose from 0 to 7.");


        }





}
            

  }


    
}
