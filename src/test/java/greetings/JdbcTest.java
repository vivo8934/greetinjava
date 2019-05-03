package greetings;


import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.fail;


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
    @Test
    public void LoadingDriver(){
        try {
            Class.forName("org.h2.Driver");
        }catch (ClassNotFoundException e){
            fail(e);
        }
    }

    @Test
    public void ConnectingToDb(){
        try {
            Class.forName("org.h2.Driver");

            Connection conn = DriverManager.getConnection(DATABASE_URL,USER,PASS);
            System.out.println(conn);
        } catch (ClassNotFoundException e){
            fail(e);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
