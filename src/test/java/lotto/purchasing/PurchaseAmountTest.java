package lotto.purchasing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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

class PurchaseAmountTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PurchaseAmount purchaseAmount = new PurchaseAmount();

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
    @ValueSource(strings = { "eight thousand", "8001" })
    void inAccurateInputs(String mockInput) {
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        try {
            purchaseAmount.ask();
        } catch (NoSuchElementException ignored) {
        }

        assertThat(outputStream.toString()).contains("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = { "8,000", "8000" })
    void accurateInputs(String mockInput) {
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        assertDoesNotThrow(purchaseAmount::ask);
    }

    @Test
    void accurateInputAfterInAccurateInputs() {
        String mockInput = "eight thousand\n8000";
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        String input = null;
        try {
            input = purchaseAmount.ask();
        } catch (NoSuchElementException ignored) {
        }

        assertThat(outputStream.toString()).contains("[ERROR]");
        assertThat(input).isEqualTo("8000");
    }
}