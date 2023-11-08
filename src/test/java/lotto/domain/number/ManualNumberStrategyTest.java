package lotto.domain.number;

import lotto.domain.Lotto;
import lotto.domain.number.ManualNumberStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ManualNumberStrategyTest {

    @Test
    void generateNumber_ValidInput_ShouldReturnLotto() {
        String validInput = "1,2,3,4,5,6";

        ManualNumberStrategy manualNumberStrategy = new ManualNumberStrategy(validInput);
        Lotto lotto = manualNumberStrategy.generateNumber();

        assertEquals(6, lotto.getNumbers().size());
    }

    @Test
    void generateNumber_InvalidInput_ShouldThrowException() {
        String invalidInput = "1,2,3,4,5"; // 6개 숫자가 아님

        assertThrows(IllegalArgumentException.class, () -> new ManualNumberStrategy(invalidInput));
    }
}
