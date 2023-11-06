package lotto.template;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class UiTest {
    PrintStream standardOut;
    OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    protected final String getSystemOutput() {
        return captor.toString().trim();
    }

    protected final void input(String... args) {
        byte[] joinedInput = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(joinedInput));
    }


    @AfterEach
    protected final void tearDown() {
        System.setOut(standardOut);
        System.out.println(getSystemOutput());
    }
}
