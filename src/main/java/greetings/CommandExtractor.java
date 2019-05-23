package greetings;

public class CommandExtractor {

    private final String language;
    String command;
    private final String name;
    public CommandExtractor(String command){

        String[] comm = command.split(" ");

        this.command = comm[0];

        if(comm.length >= 2){
            this.name = comm[1];
        }else {
            this.name = "";
        }

        if(comm.length >= 3){
            this.language = comm[2].substring(0, 1).toUpperCase() + comm[2].substring(1).toLowerCase();
        }else{
            this.language = "English";
        }
    }

    public String getCommand() {
        return command;
    }


    public String getLanguage() {
        return language;
    }

    public String getName() {
        return name;
    }
}
