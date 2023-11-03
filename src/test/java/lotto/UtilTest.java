package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UtilTest {
    @ParameterizedTest
    @ValueSource(strings = {"532", "123", "6542"})
    void isInteger_true_반환_테스트(String input) {
        assertTrue(LottoUtil.isInteger(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "321.12"})
    void isInteger_false_반환_테스트(String input) {
        assertFalse(LottoUtil.isInteger(input));
    }
}
