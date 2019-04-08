package greetings;
import java.util.HashMap;


public class Greeter {

    HashMap<String, Integer> allGreetings = new HashMap<String, Integer>();
    public String greeting(String name, String language){
        name = name.substring(0,1).toUpperCase() +  name.substring(1).toLowerCase();
        return Languages.valueOf(language).getGreets() + " " + name;
    }
}
