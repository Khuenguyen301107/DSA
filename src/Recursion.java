 public class Recursion {
private static void sayHi(int count){
    System.out.println("Hi!");
    if(count < 1){
        return;
    }
    sayHi(count - 1);
}

    public static void main(String[]args){
         sayHi(8);
    }
    

 
    
}
