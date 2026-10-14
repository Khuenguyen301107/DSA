import java.util.Scanner;

class Student {
    String studentId;
    String fullName;
    String gender;
    double academicScore;
    double trainingScore;

    public Student(String studentId, String fullName, String gender, double academicScore, double trainingScore) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.gender = gender;
        this.academicScore = academicScore;
        this.trainingScore = trainingScore;
    }

  
    public String toString() {
        return String.format("ID: %s | Name: %s | Gender: %s | Academic: %.1f | Training: %.1f",
                studentId, fullName, gender, academicScore, trainingScore);
    }
}

public class Lab02Bai02 {
    public static Student createStudentFromInput(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();

        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();

        System.out.print("Enter academic score: ");
        double academicScore = scanner.nextDouble();

        System.out.print("Enter training score: ");
        double trainingScore = scanner.nextDouble();
        scanner.nextLine();

        return new Student(studentId, fullName, gender, academicScore, trainingScore);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the initial number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Student[] students = new Student[n + 10];
        int currentCount = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("Entering information for student " + (i + 1) + ":");
            students[currentCount] = createStudentFromInput(scanner);
            currentCount++;
        }

        System.out.print("Enter StudentID to search: ");
        String searchID = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < currentCount; i++) {
            if (students[i].studentId.equals(searchID)) {
                System.out.println("Students found: " + students[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No student was found.");
        }

        System.out.println("Student with academic score >= 70 and training score >= 70: ");
        boolean found1 = false;
        for (int i = 0; i < currentCount; i++) {
            if (students[i].academicScore >= 70.0 && students[i].trainingScore >= 70.0) {
                System.out.println(students[i]);
                found1 = true;
            }
        }
        if (!found1) {
            System.out.println("No student satisfy the requirement.");
        }

        int maleCount = 0;
        int femaleCount = 0;
        for (int i = 0; i < currentCount; i++) {
            if (students[i].gender.equalsIgnoreCase("Male")) {
                maleCount++;
            } else if (students[i].gender.equalsIgnoreCase("Female")) {
                femaleCount++;
            }
        }
        System.out.println("Number of male students is: " + maleCount);
        System.out.println("Number of female students is: " + femaleCount);

        System.out.println("Sort the student list in ascending order by academic score: ");
        for (int i = 0; i < currentCount - 1; i++) {
            for (int j = 0; j < currentCount - i - 1; j++) {
                if (students[j].academicScore > students[j + 1].academicScore) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                } else if (students[j].academicScore == students[j + 1].academicScore) {
                    if (students[j].trainingScore > students[j + 1].trainingScore) {
                        Student temp = students[j];
                        students[j] = students[j + 1];
                        students[j + 1] = temp;
                    }
                }
            }
        }

        for (int i = 0; i < currentCount; i++) {
            System.out.println(students[i]);
        }

        System.out.println("Enter information of new students: ");
        Student newStudent = createStudentFromInput(scanner);
        students[currentCount] = newStudent;
        currentCount++;

        for (int i = 0; i < currentCount - 1; i++) {
            for (int j = 0; j < currentCount - i - 1; j++) {
                if (students[j].academicScore > students[j + 1].academicScore) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                } else if (students[j].academicScore == students[j + 1].academicScore) {
                    if (students[j].trainingScore > students[j + 1].trainingScore) {
                        Student temp = students[j];
                        students[j] = students[j + 1];
                        students[j + 1] = temp;
                    }
                }
            }
        }
System.out.println("Students list after insertion: ");
        for (int i = 0; i < currentCount; i++) {
            System.out.println(students[i]);
        }

        System.out.print("Enter StudentID to delete:  ");
        String deleteID = scanner.nextLine();
        int deleteIndex = -1;
        for (int i = 0; i < currentCount; i++) {
            if (students[i].studentId.equals(deleteID)) {
                deleteIndex = i;
                break;
            }
        }
        if (deleteIndex != -1) {
            for (int i = deleteIndex; i < currentCount - 1; i++) {
                students[i] = students[i + 1];

            }
            students[currentCount - 1] = null;
            currentCount--;
            System.out.println("Student deleted.\nUpdate list: ");
            for(int i = 0; i< currentCount;i++){
                System.out.println(students[i]);
            }
        } else {
            System.out.println("No student with this studentID was found.");
        }
        

    }
}


