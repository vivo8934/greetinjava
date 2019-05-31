package greetings;
import java.sql.SQLException;
import java.util.Scanner;


public class Greet{

    public static int Counter = 0;
    private static String name;



    public static void main(String[]args) throws SQLException {


        Greeter greeter = new Greeter();
        Jdbc jdbc  = new Jdbc();
        Scanner greeting =  new Scanner(System.in);

        String command;

        System.out.println("=======================WELCOME TO MY GREETINGS APP ============================= \n \n");
        while (Counter >= 0){

            System.out.println("Enter a command  or Enter the keyword help to see all possible commands");
            command = greeting.nextLine();
            CommandExtractor commandextractor = new CommandExtractor(command);
            CommandProcessor commandprocessor = new CommandProcessor(jdbc);

            if(command.equals("exit")){
                System.exit(0);
            }
            System.out.println(commandprocessor.proccessingCommands(commandextractor));



        }

    }
}

