package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestDefault {
    private final String NEW_LINE = System.lineSeparator();
    private final PrintStream originOutput = System.out;
    private OutputStream outputCaptor;

    @BeforeEach
    void defaultTestInit() {
        outputCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputCaptor));
    }

    @AfterEach
    void defaultTestCleanUp() {
        System.setOut(originOutput);
        Console.close();
    }

    protected String getConsoleOuputMessage() {
        return outputCaptor.toString();
    }

    protected void setInputs(final String... inputs) {
        final byte[] buf = String.join(NEW_LINE, inputs).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
