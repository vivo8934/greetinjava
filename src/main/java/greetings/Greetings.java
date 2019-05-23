package greetings;

import java.sql.SQLException;

public interface Greetings {

    String greeting(String name, String language);
    String greeted(String name);


    String greeted() throws SQLException;
    void clearAllGreetings();
    void clearUser(String name);
    int count();

}
