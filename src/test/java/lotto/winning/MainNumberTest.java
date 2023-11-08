package lotto.winning;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MainNumberTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    MainNumber mainNumbers = new MainNumber();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(System.in);
        System.setOut(System.out);
        Console.close();
    }

    @ParameterizedTest
    @ValueSource(strings = { "1,2,3,4,5,99", "1,2,3,4,5,5", "1,2,3,4" })
    void inAccurateInputs(String mockInput) {
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        try {
            mainNumbers.ask();
        } catch (NoSuchElementException ignored) {
        }

        assertThat(outputStream.toString()).contains("[ERROR]");
    }

    @Test
    void accurateInputAfterInAccurateInputs() {
        String mockInput = "1,2,3,4,5,99\n1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        String input = "null";
        try {
            input = mainNumbers.ask().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
        } catch (NoSuchElementException ignored) {
        }

        assertThat(outputStream.toString()).contains("[ERROR]");
        assertThat(input).isEqualTo("1,2,3,4,5,6");
    }
}