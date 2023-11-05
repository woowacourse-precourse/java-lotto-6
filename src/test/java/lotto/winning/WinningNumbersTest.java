package lotto.winning;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    WinningNumbers winningNumbers = new WinningNumbers();

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
            winningNumbers.ask();
        } catch (NoSuchElementException ignored) {
        }

        assertThat(outputStream.toString()).contains("[ERROR]");
    }
}