import java.util.Scanner;
public class InputHello{
// first class  
  public static void main(String[] args) {
      System.out.println("What is your name?");
      Scanner userinput = new Scanner(System.in);
      String name = userinput.nextLine();
      System.out.println("Hello" + name);
}
}