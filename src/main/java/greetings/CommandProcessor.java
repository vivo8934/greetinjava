package greetings;

import java.sql.SQLException;

public class CommandProcessor {


    Greetings greetings;

    public CommandProcessor(Greetings greetings){

        this.greetings = greetings;
    }
    String proccessingCommands(CommandExtractor commandProcessor) throws SQLException {
        if(commandProcessor.getCommand().equals("greet")){
            if (commandProcessor.getName() ==  "") {
                return  "Please enter a name to greet";
            }
            return  greetings.greeting(commandProcessor.getName(), commandProcessor.getLanguage());
        }
        else if (commandProcessor.getCommand().equals("greeted")){
            if(commandProcessor.getName().isEmpty()){
                return greetings.greeted();
            }
            return  greetings.greeted(commandProcessor.getName());
        }
        else if (commandProcessor.getCommand().equals("counter")){
            int count= greetings.count();
            return "" + count;
        }

       else if (commandProcessor.getCommand().equals("clear")){
            if(commandProcessor.getName().isEmpty()){
                greetings.clearAllGreetings();
            }
            else {
                greetings.clearUser(commandProcessor.getName());
            }
            return  "";
        }
        else if(commandProcessor.getCommand().equals("help")){
            return "Here are all possible commands that work on my program \n \n 1. greet - followed by the name and the language the user is to be greeted in. \n 2. greeted - should display a list of all users that has been greeted and how many time each user has been greeted. \n 3. greeted followed by a username - returns how many times that username have been greeted. \n 4. counter - returns a count of how many unique users has been greeted. \n 5. clear - deletes of all users greeted and the reset the greet counter to 0 \n 6. clear followed by a username - delete the greet counter for the specified user and decrement the greet counter by 1. \n 7. exit - exits the application \n 8. help - shows a user an overview of all possible commands.\n \n";

        }
        else {
            return  "Invalid Command!!!";
        }

    }
    }


