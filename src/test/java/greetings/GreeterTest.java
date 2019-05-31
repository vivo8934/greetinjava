package greetings;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class GreeterTest {

    HashMap<String, Integer> allGreetings = new HashMap<String, Integer>();
    @Test
     void shouldGreet() {
         Greeter greeter = new Greeter();
         assertEquals(greeter.greeting("Mfundo", "Mandarin"), "Ni hao Mfundo");
        assertEquals(greeter.greeting("Mfundo", null), "Hello Mfundo");
     }

     @Test
     void shouldGreetedSpecificUser(){

         Greeter greeter = new Greeter();

         greeter.greeting("vivo", null);
         greeter.greeting("yamkela", "Mandarin");
         greeter.greeting("siphokazi", "Mandarin");
         greeter.greeting("siphokazi", "Mandarin");

         assertEquals(greeter.greeted("siphokazi"), "2");

     }

     @Test
     void shouldGreetedAllUsers(){



        Greeter greeter = new Greeter();
        greeter.greeting("mfundo", "Mandarin");
         greeter.greeting("mfundo", "Mandarin");
         greeter.greeting("mfundo", null);
         greeter.greeting("yash", "IsiXhosa");

         allGreetings.put("mfundo", 3);
         allGreetings.put("yash", 1);

         assertEquals(greeter.greeted(null), allGreetings.toString());

    }
    @Test
    void shouldCounter(){
        Greeter greeter = new Greeter();
        greeter.greeting("Thabang", "English");
        greeter.greeting("Mfundo", "Mandarin");
        greeter.greeting("Ziyanda", null);
        greeter.greeting("Yamkela", "IsiXhosa");
        greeter.greeting("Mfundo", "English");

        assertEquals(greeter.count(), 4);
    }
     @Test
     void  shouldClearAllGreetings(){
        Greeter greeter = new Greeter();
         greeter.greeting("Thabang", "English");
         greeter.greeting("John", "English");
         greeter.greeting("Thabang", "English");

         assertEquals(2, greeter.count());
         greeter.clearAllGreetings();
        assertEquals(0, greeter.count());

     }
     @Test
     void shouldClearUser(){
        Greeter greeter = new Greeter();
        greeter.greeting("vivo", null);
        greeter.greeting("sphokie", "IsiXhosa");
        greeter.greeting("mfundo", "Mandarin");
        greeter.greeting("vinny", "English");


        assertEquals(greeter.count(), 4);
        greeter.clearUser("vivo");
        assertEquals(greeter.count(), 3);
     }
}