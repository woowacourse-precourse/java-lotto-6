package lotto.winning;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    BonusNumber bonusNumber = new BonusNumber();

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
    @ValueSource(strings = { "99", "1,2" })
    void inAccurateInputs(String mockInput) {
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        try {
            bonusNumber.ask();
        } catch (NoSuchElementException ignored) {
        }

        assertThat(outputStream.toString()).contains("[ERROR]");
    }

    @Test
    void accurateInputAfterInAccurateInputs() {
        String mockInput = "1,2\n7";
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        Integer input = -1;
        try {
            input = bonusNumber.ask();
        } catch (NoSuchElementException ignored) {
        }

        assertThat(input).isEqualTo(7);
    }
}