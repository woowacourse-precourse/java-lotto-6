package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import lotto.constants.PrintMessages;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestDefault {
    private final String NEW_LINE = PrintMessages.NEW_LINE;
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

    protected void setInputs(String... inputs) {
        for (String input : inputs) {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
        }
    }
}
