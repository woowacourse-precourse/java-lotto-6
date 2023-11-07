package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class IOTest {

    private ByteArrayOutputStream outputStreamCaptor;
    private PrintStream standardOut; // 표준 스트림

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @BeforeEach
    void setUp() {
        standardOut = System.out;
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    protected void printResult() {
        System.setOut(standardOut);
        System.out.println(getOutput());
        Console.close();
    }

    protected String getOutput() {
        return outputStreamCaptor.toString();
    }
}
