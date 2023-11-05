package lotto;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;

@DisplayNameGeneration(ReplaceUnderscores.class)
public class MyApplicationTest {
    private static List<String> outputs = Collections.emptyList();
    private static final InputStream systemIn = System.in;
    private static final PrintStream systemOut = System.out;

    private static ByteArrayOutputStream outBuffer;

    @BeforeEach
    void setUp() {
        outputs = new ArrayList<>();
    }

    protected static void run(String... args) {
        resetInputStream(args);
        resetOutputStream();
        runMain();
        outputs = Arrays.stream(outBuffer.toString().split("\n"))
                .collect(toList());
    }

    protected static void runMain() {
        Application.main(new String[]{});
    }

    protected static void resetInputStream(String... args) {
        final byte[] buffer = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buffer));
    }

    protected static void resetOutputStream() {
        outBuffer = new ByteArrayOutputStream();
        final PrintStream outputPrintStream = new PrintStream(outBuffer);
        System.setOut(outputPrintStream);
    }


    @AfterEach
    void clean() {
        outputs = Collections.emptyList();
        Console.close();
    }

    @AfterAll
    static void tearDown() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }


    protected static List<String> outputs() {
        return List.copyOf(outputs);
    }

    protected static void println(String str) {
        systemOut.println(str);
    }
}
