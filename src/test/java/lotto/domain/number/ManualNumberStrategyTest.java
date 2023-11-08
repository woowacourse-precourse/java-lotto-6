package lotto.domain.number;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ManualNumberStrategyTest {
    @DisplayName("유효한 로또 입력을 받으면 예외가 발생하지 않는다.")
    @Test
    void testValidInputLotto() {
        String validInput = "1,2,3,4,5,6";

        ManualNumberStrategy manualNumberStrategy = new ManualNumberStrategy(validInput);
        Lotto lotto = manualNumberStrategy.generateNumber();

        assertEquals(6, lotto.getNumbers().size());
    }

    @DisplayName("로또 개수가 6개 미만일 시 예외가 발생한다.")
    @Test
    void testLottoNumberLessThan6Numbers() {
        String invalidInput = "1,2,3,4,5";

        assertThrows(IllegalArgumentException.class, () -> new ManualNumberStrategy(invalidInput));
    }

    @DisplayName("로또 개수가 6개를 초과할 시 예외가 발생한다.")
    @Test
    void testLottoNumberMoreThan6Numbers() {
        String invalidInput = "1,2,3,4,5,6,7";

        assertThrows(IllegalArgumentException.class, () -> new ManualNumberStrategy(invalidInput));
    }

    @DisplayName("로또 입력 값이 없을 경우 예외가 발생한다.")
    @Test
    void testLottoNumberWithEmptyInput() {
        String invalidInput = "";

        assertThrows(IllegalArgumentException.class, () -> new ManualNumberStrategy(invalidInput));
    }
}
