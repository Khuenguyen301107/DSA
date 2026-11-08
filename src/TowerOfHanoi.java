import java.util.Stack;

public class TowerOfHanoi {

   
    static class Task {
        int n;
        char from, to, aux;

        Task(int n, char from, char to, char aux) {
            this.n = n;
            this.from = from;
            this.to = to;
            this.aux = aux;
        }
    }

    public static void main(String[] args) {
        Stack<Task> stack = new Stack<>();

        
        stack.push(new Task(3, 'A', 'C', 'B'));

        while (!stack.isEmpty()) {
            Task cur = stack.pop(); 

            if (cur.n == 1) {
         
                System.out.println("Move disk from " + cur.from + " to " + cur.to);
            } else {
              
                
                stack.push(new Task(cur.n - 1, cur.aux, cur.to, cur.from)); 
                stack.push(new Task(1, cur.from, cur.to, cur.aux));        
                stack.push(new Task(cur.n - 1, cur.from, cur.aux, cur.to)); 
            }
        }
    }
}