package greetings;
import java.util.HashMap;


public class Greeter {

    HashMap<String, Integer> allGreetings = new HashMap<String, Integer>();

    public String greeting(String name, String language){
//        if (allGreetings.containsKey(name)) {
//            allGreetings.put(name, allGreetings.get(name) + 1);
//        } else {
//            allGreetings.put(name, 1);
//        }
        Jdbc db = new Jdbc();
        db.addUser(name);
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
            if (name == null){
                System.out.println("======People who have been greeted and the number of greets per person========\n");
                Jdbc db = new Jdbc();
                db.greeted();
                return "";// allGreetings.toString();
            }
            else{
                System.out.println("======  " + name + " has been greeted ==========\n");
                Jdbc db = new Jdbc();
                db.greeted(name);
                return   " ";//allGreetings.get(name).toString();
            }
        }
        catch (NullPointerException e){
            return allGreetings.toString();
        }
    }

    public void clearAllGreetings(){
        System.out.println("============ The Greetings have been cleared================");
        Jdbc db = new Jdbc();
        db.clearAllGreetings();
        allGreetings.clear();
        allGreetings.size();
    }

    public void clearUser(String name){
        System.out.println("=========== " + name  + " Has been removed from greetings ========== \n");
       Jdbc db = new Jdbc();
       db.clearUser(name);
       allGreetings.remove(name);
    }

    public int count(){
        Jdbc db = new Jdbc();
//        db.count();
        return db.count(); }
}
