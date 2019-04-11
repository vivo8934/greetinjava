package greetings;
import java.util.HashMap;


public class Greeter {

    HashMap<String, Integer> allGreetings = new HashMap<String, Integer>();

    public String greeting(String name, String language){
        if (allGreetings.containsKey(name)) {
            allGreetings.put(name, allGreetings.get(name) + 1);
        } else {
            allGreetings.put(name, 1);
        }
        name = name.substring(0,1).toUpperCase() +  name.substring(1).toLowerCase();
        return Languages.valueOf(language).getGreets() + " " + name;
    }

    public String greeted(String name){
        try {
            if (name == null){
                System.out.println("======People who have been greeted and the number of greets per person========\n");
                return allGreetings.toString();
            }
            else{
                System.out.println("======  " + name + " has been greeted ==========\n");
                return allGreetings.get(name).toString();
            }
        }
        catch (NullPointerException e){
            return allGreetings.toString();
        }
    }

    public void clearAllGreetings(){
        allGreetings.clear();
    }

    public void clearUser(String name){
       allGreetings.remove(name);
    }



}
