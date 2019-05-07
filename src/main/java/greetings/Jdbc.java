package greetings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public abstract class Jdbc implements Greetings {



    final String  INSERT_USER_SQL = "INSERT into greeted (name, timesGreeted) values(?, ?)";
    final String  FIND_USER_SQL = "SELECT timesGreeted FROM greeted WHERE name = ?";
    final String  UPDATE_USER_SQL = "UPDATE greeted SET  timesGreeted = ? WHERE name = ?";
    final String  FIND_ALL_SQL = "SELECT COUNT(*) AS name From greeted";
    final String FIND_LIST_SQL = "SELECT * FROM greeted";
    final String  DELETE_USER_SQL = "DELETE FROM greeted WHERE name = ?";
    final String DELETE_ALL_SQL = "DELETE FROM greeted";


    Connection conn;
    PreparedStatement psCreateNewGreet;
    PreparedStatement psCounter;
    PreparedStatement psCounterUpdate;
    PreparedStatement psAllGreetedNames;
    PreparedStatement psListNames;
    PreparedStatement psRemoveName;
    PreparedStatement psRemoveAll;

    final String USER = "sa";
    final String PASS = "";
    final String DATABASE_URL = "jdbc:h2:./target/greetings-console";

    public  Jdbc(){
        try{
            conn = DriverManager.getConnection(DATABASE_URL,USER,PASS);
            psCreateNewGreet = conn.prepareStatement(INSERT_USER_SQL);
            psCounter = conn.prepareStatement(FIND_USER_SQL);
            psCounterUpdate = conn.prepareStatement(UPDATE_USER_SQL);
            psAllGreetedNames = conn.prepareStatement(FIND_ALL_SQL);
            psListNames = conn.prepareStatement(FIND_LIST_SQL);
            psRemoveName = conn.prepareStatement(DELETE_USER_SQL);
            psRemoveAll = conn.prepareStatement(DELETE_ALL_SQL);


        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void addUser(String userName){

        try {
            psCreateNewGreet.setString(1, userName);
            psCreateNewGreet.setInt(2, 1);
            psCreateNewGreet.execute();
        }catch (Exception e) {

        }
    }
}
