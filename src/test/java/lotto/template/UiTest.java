package lotto.template;

import camp.nextstep.edu.missionutils.Console;
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

    protected void input(String... args) {
        final byte[] joinedInput = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(joinedInput));
        Console.close();
    }


    @AfterEach
    protected final void tearDown() {
        System.setOut(standardOut);
        System.out.println(getSystemOutput());
    }
}
