package greetings;


import java.sql.Connection;
import java.sql.DriverManager;



public class JdbcTest {

    final String USER = "sa";
    final String PASS = "";

    final String DATABASE_URL = "jdbc:h2:./target/greetings-console";

    public Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");

        Connection conn;
        conn = DriverManager.getConnection(DATABASE_URL,USER,PASS);
        return conn;
    }


}
