package greetings;
import java.util.Scanner;
import java.util.HashMap;

public class Greet{

    public static int Counter = 0;
    public String name;
    public String language;

    HashMap<String, Integer> allGreetings = new HashMap<String, Integer>();

    public static void main(String[]args){


        Scanner greeting =  new Scanner(System.in);

        String command;

        while (Counter >= 0){

            System.out.println("Enter a command");
            command = greeting.nextLine();

            String[] comm = command.split(" ");



        }

    }
}

