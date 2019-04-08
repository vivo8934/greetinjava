package greetings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreeterTest {
    @Test
     void shouldGreet() {
         Greeter greeter = new Greeter();
         assertEquals(greeter.greeting("Mfundo", "Mandarin"), "Ni hao Mfundo");
     }
}