package lotto.template;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class UiTest {
    PrintStream standardOut;
    OutputStream captor;

    @BeforeEach
    protected void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    protected String getSystemOutput() {
        return captor.toString().trim();
    }

    @AfterEach
    protected void tearDown() {
        System.setOut(standardOut);
        System.out.println(getSystemOutput());
    }
}
