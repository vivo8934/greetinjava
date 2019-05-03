package greetings;

public interface Greetings {

    String greeting(String name, String language);
    String greeted(String name);
    String greeted();
    void clearAllGreetings();
    void clearUser(String name);
    int count();

}
