package greetings;

import java.sql.*;
import java.util.HashMap;

public class Jdbc implements Greetings {



    final String  INSERT_USER_SQL = "INSERT into greeted (name, timesGreeted) values(?, ?)";
    final String  FIND_USER_SQL = "SELECT * FROM greeted WHERE name = ?";
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
    PreparedStatement psClearName;
    PreparedStatement psClearAll;

    final String USER = "sa";
    final String PASS = "";
    final String DATABASE_URL = "jdbc:h2:./target/greetings-console";

    public  Jdbc(){
        try{
            conn = DriverManager.getConnection(DATABASE_URL,USER,PASS);
            psCreateNewGreet = conn.prepareStatement(INSERT_USER_SQL);
           psCounter = conn.prepareStatement(FIND_USER_SQL);
            psAllGreetedNames = conn.prepareStatement(FIND_ALL_SQL);
            psClearAll = conn.prepareStatement(DELETE_ALL_SQL);
            psClearName = conn.prepareStatement(DELETE_USER_SQL);
            psCounterUpdate = conn.prepareStatement(UPDATE_USER_SQL);
            psListNames = conn.prepareStatement(FIND_LIST_SQL);




        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void addUser(String userName){

        try {
            psCounter.setString(1, userName);
            ResultSet rsName = psCounter.executeQuery();

            if (!rsName.next()){
                psCreateNewGreet.setString(1, userName);
                psCreateNewGreet.setInt(2, 1);
                psCreateNewGreet.execute();
            }else {
                int nameCount = rsName.getInt("timesGreeted");
                psCounterUpdate.setInt(1, ++nameCount);
                psCounterUpdate.setString(2, userName);
                psCounterUpdate.execute();
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }


    @Override
    public String greeting(String name, String language)
    {
        addUser(name);
        try {
            name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
            return Languages.valueOf(language).getGreets() + " " + name;
        }catch (NullPointerException e) {
            name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
            return Languages.valueOf("English").getGreets() + " " + name;
        }
    }

    @Override
    public String greeted(String name) {

        HashMap<String, Integer> allGreetings = new HashMap<String, Integer>();
        try {
            psCounter.setString(1,name);
            ResultSet rs = psCounter.executeQuery();
            if (rs.next()){
                allGreetings.put(rs.getString("name"), rs.getInt("timesGreeted"));
               return String.format("Count %s ",rs.getInt("timesGreeted"));
//                System.out.println();
            }
            return "0";
        } catch (SQLException e){
            return "0";
        }
    }

    @Override
    public String greeted()  {
        HashMap<String, Integer> allGreetings = new HashMap<String, Integer>();
        try {
            ResultSet rs = psListNames.executeQuery();
            while(rs.next()) {
                allGreetings.put(rs.getString("name"), rs.getInt("timesGreeted"));

            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return allGreetings.toString();
    }



    @Override
    public void clearAllGreetings() {
        try{
            psClearAll.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error:" + e);
        }
    }

    @Override
    public void clearUser(String name) {

        try {
            psClearName.setString(1, name);
            psClearName.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error " + e);
        }
    }

    @Override
    public int count() {
        HashMap<String, Integer> allGreetings = new HashMap<String, Integer>();
        try{
            ResultSet rs = psListNames.executeQuery();

            while (rs.next()){
                allGreetings.put(rs.getString("name"), rs.getInt("timesGreeted"));

            }


        }
        catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
        return  allGreetings.size();
    }
}
