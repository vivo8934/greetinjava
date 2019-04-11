package greetings;
import java.util.Scanner;


public class Greet{

    public static int Counter = 0;
    private static String name;



    public static void main(String[]args){


        Greeter greeter = new Greeter();
        Scanner greeting =  new Scanner(System.in);

        String command;

        System.out.println("=======================WELCOME TO MY GREETINGS APP ============================= \n \n");
        while (Counter >= 0){

            System.out.println("Enter a command  or Enter the keyword help to see all possible commands");
            command = greeting.nextLine();

            String[] comm = command.split(" ");

            if(comm[0].equalsIgnoreCase("greet")){
                if(comm.length == 3){
                    String msg = greeter.greeting(comm[1], comm[2]);
                    System.out.println(msg);
                }else {
                    String msg = greeter.greeting(comm[1], "English");
                    System.out.println(msg);
                }
            }
            else if(comm[0].equalsIgnoreCase("greeted")){


                name = null;
                if(comm.length == 2) {
                    name = comm[1];
                }

                    String msg = (String) greeter.greeted(name);
                    System.out.println(msg);

            }
            else if(comm[0].equalsIgnoreCase("clear")){
                if(comm.length  == 2){
                    name = comm[1];
                    greeter.clearUser(name);
                }
                else {
                    greeter.clearAllGreetings();
                }
                }
            else if(comm[0].equalsIgnoreCase("exit")){
                break;
            }
            else {
                System.out.println("Invalid command!");
            }

        }

    }
}

