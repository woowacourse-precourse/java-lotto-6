package lotto.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class WriterMessengerTest {
    private PrintStream standardOut;
    private OutputStream captor;
    private Messenger writerMessenger;

    @BeforeEach
    void setUp() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        writerMessenger = new WriterMessenger();
    }

    @DisplayName("메시지 출력 테스트")
    @Test
    void print() {
        String input = "message";
        String expected = "message" + System.lineSeparator();

        writerMessenger.print(input);

        assertThat(captor.toString()).isEqualTo(expected);
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }
}