import java.util.Scanner;

public class Lab03Bai3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter maximum printer queue capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); 

        CircularQueue printerQueue = new CircularQueue(capacity);
        int nextJobId = 101; 
        while (true) {
            System.out.println("\n===== PRINTER JOB MANAGEMENT =====");
            System.out.println("1. Submit Print Job");
            System.out.println("2. Process Next Job");
            System.out.println("3. View Next Job");
            System.out.println("4. Display Waiting Jobs");
            System.out.println("5. Count Waiting Jobs");
            System.out.println("6. Exit");
            System.out.println("7. Run Part C Demo (Capacity = 4)");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1: 
                    if (printerQueue.isFull()) {
                        System.out.println("Printer queue is full! Cannot accept new jobs right now.");
                        break;
                    }

                    System.out.print("Student Name: ");
                    String studentName = scanner.nextLine().trim();

                    System.out.print("Number of Pages: ");
                    int pages = scanner.nextInt();
                    scanner.nextLine(); 

                    PrintJob newJob = new PrintJob(nextJobId, studentName, pages);
                    nextJobId++;

                    printerQueue.enqueue(newJob);
                    System.out.println("Job #" + newJob.getJobId() + " submitted successfully.");
                    break;

                case 2: 
                    if (printerQueue.isEmpty()) {
                        System.out.println("No waiting jobs to process.");
                    } else {
                        PrintJob currentJob = printerQueue.dequeue();
                        System.out.println("Processing Job #" + currentJob.getJobId());
                        System.out.println("Student: " + currentJob.getStudentName());
                        System.out.println("Pages: " + currentJob.getNumberOfPages());
                        System.out.println("Print job completed.");
                    }
                    break;

                case 3: 
                    if (printerQueue.isEmpty()) {
                        System.out.println("No waiting jobs in the queue.");
                    } else {
                        System.out.println("Next Job:");
                        System.out.println(printerQueue.peek());
                    }
                    break;

                case 4: 
                    printerQueue.display();
                    break;

                case 5: 
                    System.out.println("Total waiting jobs: " + printerQueue.size());
                    break;

                case 6: 
                    System.out.println("Exiting Printer Job Management System...");
                    scanner.close();
                    return;

                case 7: 
                    runPartCDemo();
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 7.");
            }
        }
    }

   
    public static void runPartCDemo() {
        System.out.println("\n===== PART C: CIRCULAR QUEUE BEHAVIOR (CAPACITY = 4) =====");
        CircularQueue demoQueue = new CircularQueue(4);

        
        demoQueue.enqueue(new PrintJob(101, "Alice", 10));
        printStep(1, "Enqueue Job 101", demoQueue);

       
        demoQueue.enqueue(new PrintJob(102, "Bob", 5));
        printStep(2, "Enqueue Job 102", demoQueue);

       
        demoQueue.enqueue(new PrintJob(103, "Charlie", 20));
        printStep(3, "Enqueue Job 103", demoQueue);

        demoQueue.enqueue(new PrintJob(104, "David", 15));
        printStep(4, "Enqueue Job 104", demoQueue);

     
        demoQueue.dequeue();
        printStep(5, "Dequeue", demoQueue);

        
        demoQueue.dequeue();
        printStep(6, "Dequeue", demoQueue);

       
        demoQueue.enqueue(new PrintJob(105, "Eve", 8));
        printStep(7, "Enqueue Job 105 (Rear wraps to 0)", demoQueue);

       
        demoQueue.enqueue(new PrintJob(106, "Frank", 12));
        printStep(8, "Enqueue Job 106", demoQueue);
    }

    
    private static void printStep(int step, String operation, CircularQueue q) {
        System.out.println("\nStep " + step + ": " + operation);
        System.out.println("front = " + q.getFront() + " | rear = " + q.getRear() + " | size = " + q.size());
        q.displayQueueIdsOnly();
    }

   
    static class PrintJob {
        private int jobId;
        private String studentName;
        private int numberOfPages;

        public PrintJob(int jobId, String studentName, int numberOfPages) {
            this.jobId = jobId;
            this.studentName = studentName;
            this.numberOfPages = numberOfPages;
        }

        public int getJobId() {
            return jobId;
        }

        public String getStudentName() {
            return studentName;
        }

        public int getNumberOfPages() {
            return numberOfPages;
        }

        @Override
        public String toString() {
            return "#" + jobId + " " + studentName + " " + numberOfPages + " pages";
        }
    }

    
    static class CircularQueue {
        private PrintJob[] queue;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        public CircularQueue(int capacity) {
            this.capacity = capacity;
            this.queue = new PrintJob[capacity];
            this.front = 0;
            this.rear = -1;
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }

        public int size() {
            return size;
        }

        public void enqueue(PrintJob job) {
            if (isFull()) {
                System.out.println("Queue is full! Cannot add Job #" + job.getJobId());
                return;
            }
            rear = (rear + 1) % capacity;
            queue[rear] = job;
            size++;
        }

        public PrintJob dequeue() {
            if (isEmpty()) {
                return null;
            }
            PrintJob removedJob = queue[front];
            queue[front] = null;
            front = (front + 1) % capacity;
            size--;
            return removedJob;
        }

        public PrintJob peek() {
            if (isEmpty()) {
                return null;
            }
            return queue[front];
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("No waiting jobs in the queue.");
                return;
            }
            System.out.println("Waiting Jobs (Front to Rear):");
            for (int i = 0; i < size; i++) {
                int index = (front + i) % capacity;
                System.out.println(queue[index]);
            }
        }

       
        public void displayQueueIdsOnly() {
            System.out.print("Queue (Front -> Rear): ");
            for (int i = 0; i < size; i++) {
                int index = (front + i) % capacity;
                System.out.print(queue[index].getJobId());
                if (i < size - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        public int getFront() {
            return front;
        }

        public int getRear() {
            return rear;
        }
    }
}