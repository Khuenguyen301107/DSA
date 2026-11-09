import java.util.Scanner;

public class ArrayStack{
private String[] stack;
private int top;
private int capacity;
public ArrayStack(int capacity){
       this.capacity = capacity;
       this.stack = new String[capacity];
       this.top = -1;
}

public void push(String URL){
       if(isFull()) {
        System.out.println("History is full. Cannot add." + URL);
        return;
       } else {
        top++;
        stack[top] = URL;
       }
}

public String pop(){
    if(isEmpty()){
        return null; 
    } else {
        String topURL = stack[top];
        stack[top] = null;
        top-- ;
        return topURL;
    }
    
}

public String peek(){
    if(isEmpty()){
        return null;
    } 
    return stack[top];
}

public boolean isEmpty(){
    return top == -1;
}
public boolean isFull(){
    return top == capacity - 1;
}
public int size(){
    return top + 1;
}

public void display(){
    if(isEmpty()){
        System.out.println("History is empty.");
        return;
    } 
    System.out.println("Browser History (Top to Bottom):  ");
           for(int i = top;i>=0;i--){
            System.out.println(stack[i]);
           }
}


      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter maximum number of history URLs: ");
        int maxCapacity = scanner.nextInt();
        scanner.nextLine(); 

        ArrayStack historyStack = new ArrayStack(maxCapacity);
        String currentPage = null;
        System.out.println("\n===== BROWSER HISTORY =====");
            System.out.println("1. Visit New Page");
            System.out.println("2. Go Back");
            System.out.println("3. View Current Page");
            System.out.println("4. Display History");
            System.out.println("5. Exit");

        while (true) {
           
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume leftover newline

            switch (choice) {
                case 1: 
                    if (currentPage != null && historyStack.isFull()) {
                        System.out.println("History stack is full! Cannot visit a new page.");
                        System.out.println("Current Page: " + currentPage);
                        break;
                    }

                    System.out.print("Enter URL: ");
                    String newUrl = scanner.nextLine().trim();

                    // If a current page exists, push it onto the history stack
                    if (currentPage != null) {
                        historyStack.push(currentPage);
                    }

                    // Update current page to the new URL
                    currentPage = newUrl;
                    System.out.println("Current Page: " + currentPage);
                    break;

                case 2: // Go Back
                    // Additional Requirement 3: If history is empty, display an appropriate message
                    if (historyStack.isEmpty()) {
                        System.out.println("No previous pages available.");
                    } else {
                        System.out.println("Going back...");
                        currentPage = historyStack.pop();
                    }

                    if (currentPage != null) {
                        System.out.println("Current Page: " + currentPage);
                    }
                    break;

                case 3: // View Current Page
                    if (currentPage == null) {
                        System.out.println("No page currently open.");
                    } else {
                        System.out.println("Current Page: " + currentPage);
                    }
                    break;

                case 4: // Display History
                    historyStack.display();
                    break;

                case 5: // Exit
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }
        }
    }
}
