package greetings;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandProcessorTest {

    @Test
    void getCommandGreeting() throws SQLException {

        CommandExtractor commandextractor = new CommandExtractor("greet mfundo");
        CommandProcessor commandprocessor = new CommandProcessor(new Jdbc());

        assertEquals(commandprocessor.proccessingCommands(commandextractor), "Hello Mfundo");
    }

    @Test
    void getCommandGreeted() throws SQLException {


        CommandExtractor commandextractor  = new CommandExtractor("greeted");
        CommandProcessor commandprocessor = new CommandProcessor(new Jdbc());
        CommandProcessor commandProcessor1 = new CommandProcessor(new Jdbc());
        commandProcessor1.proccessingCommands(new CommandExtractor("clear"));

        assertEquals("{}", commandprocessor.proccessingCommands(commandextractor));

    }
}