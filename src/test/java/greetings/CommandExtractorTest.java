package greetings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandExtractorTest {

    @Test
    void getCommandGreet(){
        CommandExtractor commandExtractor = new CommandExtractor("greet jan English");

        assertEquals(commandExtractor.getCommand(), "greet");
        assertEquals(commandExtractor.getName(), "jan");
        assertEquals(commandExtractor.getLanguage(), "English");

    }

    @Test
    void getCommandGreet2(){
        CommandExtractor commandExtractor = new CommandExtractor("greet jan");

        assertEquals(commandExtractor.getCommand(), "greet");
        assertEquals(commandExtractor.getName(), "jan");
        assertEquals(commandExtractor.getLanguage(), "English");

    }

    @Test
    void getCommandGreet3(){
        CommandExtractor commandExtractor = new CommandExtractor("greet");

        assertEquals(commandExtractor.getCommand(), "greet");
        assertEquals(commandExtractor.getName(), "");
        assertEquals(commandExtractor.getLanguage(), "English");

    }
}