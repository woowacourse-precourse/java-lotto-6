package mytest;

import lotto.view.inputvalidator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PriceInputTest {
    private static final InputValidator inputValidate = new InputValidator();
    @ParameterizedTest
    @ValueSource(strings = {"100a", "100a", "aa", ",!@#."})
    @DisplayName("숫자가 아닌 값이 들어오면 예외처리.")
    void priceInputTest(String testInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidate.lottoWinningNumberValidate(testInput);
        });
    }
    @ParameterizedTest
    @ValueSource(strings = {""," ", "10 0a", " 1000", "1000 ", "200 0"})
    @DisplayName("빈 칸이 들어오면 예외처리")
    void priceBlankInputTest(String testInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidate.lottoWinningNumberValidate(testInput);
        });
    }
    @ParameterizedTest
    @ValueSource(strings = {"2000", "3000"})
    @DisplayName("정상입력 테스트")
    void validPriceInputTest(String testInput) {
        assertDoesNotThrow(() -> {
            inputValidate.lottoWinningNumberValidate(testInput);
        });
    }
}
