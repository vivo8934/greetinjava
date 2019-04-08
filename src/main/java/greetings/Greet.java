package greetings;
import java.util.Scanner;


public class Greet{

    public static int Counter = 0;

    public static void main(String[]args){


        Greeter greeter = new Greeter();
        Scanner greeting =  new Scanner(System.in);

        String command;

        while (Counter >= 0){

            System.out.println("Enter a command");
            command = greeting.nextLine();

            String[] comm = command.split(" ");

            if(comm[0].equalsIgnoreCase("greet")){
                String msg = greeter.greeting(comm[1], comm[2]);
                System.out.println(msg);
            }
            else {
                System.out.println("Invalid command!");
            }

        }

    }
}

