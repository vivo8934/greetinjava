package greetings;
import java.sql.SQLException;
import java.util.HashMap;


public class Greeter implements Greetings {

    HashMap<String, Integer> allGreetings = new HashMap<String, Integer>();

    public String greeting(String name, String language){
     if (allGreetings.containsKey(name)) {
            allGreetings.put(name, allGreetings.get(name) + 1);
        } else {
            allGreetings.put(name, 1);
        }
        try {
            name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
            return Languages.valueOf(language).getGreets() + " " + name;
        }catch (NullPointerException e) {
            name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
            return Languages.valueOf("English").getGreets() + " " + name;
        }
    }
    public String greeted(String name){
        try {
            if (name.isEmpty()){
                System.out.println("======People who have been greeted and the number of greets per person========\n");

                return  allGreetings.toString();
            }
            else{
                System.out.println("======  " + name + " has been greeted ==========\n");

                return   allGreetings.get(name).toString();
            }
        }
        catch (NullPointerException e){
            return allGreetings.toString();
        }
    }

    @Override
    public String greeted() throws SQLException {
        return allGreetings.toString();
    }


    public void clearAllGreetings(){
        System.out.println("============ The Greetings have been cleared================");
        allGreetings.clear();
        allGreetings.size();
    }

    public void clearUser(String name){
        System.out.println("=========== " + name  + " Has been removed from greetings ========== \n");
       allGreetings.remove(name);
    }

    public int count(){
        return allGreetings.size();
    }
}
