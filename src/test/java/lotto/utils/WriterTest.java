package lotto.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class WriterTest {
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    void setUp() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @Test
    void print() {
        String input = "my message";
        String expected = "my message" + System.lineSeparator();

        Writer.print(input);

        assertThat(captor.toString()).isEqualTo(expected);
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }
}