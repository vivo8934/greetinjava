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
            else if(comm[0].equalsIgnoreCase("counter")){
                int msg = greeter.count();
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
            else if(comm[0].equalsIgnoreCase("help")){
                System.out.println("Here are all possible commands that work on my program \n \n 1. greet - followed by the name and the language the user is to be greeted in. \n 2. greeted - should display a list of all users that has been greeted and how many time each user has been greeted. \n 3. greeted followed by a username - returns how many times that username have been greeted. \n 4. counter - returns a count of how many unique users has been greeted. \n 5. clear - deletes of all users greeted and the reset the greet counter to 0 \n 6. clear followed by a username - delete the greet counter for the specified user and decrement the greet counter by 1. \n 7. exit - exits the application \n 8. help - shows a user an overview of all possible commands.\n \n");
            }
            else {
                System.out.println("Invalid command!");
            }

        }

    }
}

