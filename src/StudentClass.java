import java.util.Scanner;

public class StudentClass {

    static class Student {
        private String studentId;
        private String name;
        private String major;
        private double gpa;

        public Student(String studentId, String name, String major, double gpa) {
            this.studentId = studentId;
            this.name = name;
            this.major = major;
            this.gpa = gpa;
        }

        public String getstudentId() {
            return studentId;
        }

        public void setstudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getname() {
            return name;
        }

        public void setname(String name) {
            this.name = name;
        }

        public String getmajor() {
            return major;
        }

        public void setmajor(String major) {
            this.major = major;
        }

        public double getgpa() {
            return gpa;
        }

        public void setgpa(double gpa) {
            this.gpa = gpa;
        }

        @Override 
        public String toString() {
            return studentId + " - " + name + " - " + major + " - " + gpa;
        }
    }

    static class StudentStack {
        private Node top;
        private int size;

        static class Node {
            Student data;
            Node next;
            Node(Student data) {
                this.data = data;
            }
        }

        public StudentStack() {
            top = null;
            size = 0;
        }  

        public void push(Student s) {
            Node temp = top; 
            while (temp != null) {
                if (temp.data.getstudentId().equalsIgnoreCase(s.getstudentId())) {
                    System.out.println("Error because of duplicate! Input another information.");
                    return;
                }
                temp = temp.next;
            }
            if (s.getgpa() < 0.0 || s.getgpa() > 4.0) {
                System.out.println("Error: GPA must be between 0.0 and 4.0!");
                return;
            }

            Node newNode = new Node(s);
            newNode.next = top;
            top = newNode;
            size++;
            System.out.println("Added student successfully!");
        }

        public boolean isEmpty() {
            return top == null;
        }

        public int getsize() {
            return size;
        }

        public Student peek() {
            if (isEmpty()) return null; 
            return top.data;
        }

        public Student pop() {
            if (isEmpty()) return null;
            Node temp = top;
            top = top.next;
            temp.next = null;
            size--;
            return temp.data;
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Current Student Stack is empty.");
                return;
            }
            Node temp = top;
            System.out.println("Current student stack:");
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }

        public Student search(String studentId) {
            if (isEmpty()) return null;
            Node temp = top;
            while (temp != null) {
                if (temp.data.getstudentId().equalsIgnoreCase(studentId)) {
                    System.out.println("StudentId has been found!");
                    return temp.data;
                }
                temp = temp.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentStack stack = new StudentStack();

         System.out.println("\n==== STUDENT STACK MANAGEMENT ==========");
            System.out.println("1. Add a new student");
            System.out.println("2. Remove the most recently added student");
            System.out.println("3. View the top student");
            System.out.println("4. Search for a student by ID");
            System.out.println("5. Display all students");
            System.out.println("6. Count students");
            System.out.println("0. Exit");
            System.out.println("============================================");
           
        while (true) {
             System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Major: ");
                    String major = scanner.nextLine();
                    System.out.print("Enter GPA (0.0 - 4.0): ");
                
                    String gpaInput = scanner.nextLine().replace(',', '.');
                    double gpa = Double.parseDouble(gpaInput);

                    Student s = new Student(id, name, major, gpa);
                    stack.push(s);
                    break;

                case 2:
                    Student removed = stack.pop();
                    if (removed != null) {
                        System.out.println("Removed student: " + removed);
                    } else {
                        System.out.println("Error: Stack is empty.");
                    }
                    break;

                case 3:
                    Student topStudent = stack.peek();
                    if (topStudent != null) {
                        System.out.println("Top student: " + topStudent);
                    } else {
                        System.out.println("Error: Stack is empty.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID to search: ");
                    String searchId = scanner.nextLine();
                    Student found = stack.search(searchId);
                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Student with ID " + searchId + " not found.");
                    }
                    break;

                case 5:
                    stack.display();
                    break;

                case 6:
                    System.out.println("Total students: " + stack.getsize());
                    break;

                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please choose from 0 to 6.");
            }
        }
    }
}