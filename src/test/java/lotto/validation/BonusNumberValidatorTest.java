package lotto.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusNumberValidatorTest {
    @Test
    void 보너스번호_입력이_null이면_예외발생() {
        // given
        String bonusNumber = null;

        // when, then
        assertThrowOnInvalidBonusNumber(bonusNumber);
    }

    @Test
    void 보너스번호_입력이_빈문자열이면_예외발생() {
        // given
        String bonusNumber = "";

        // when, then
        assertThrowOnInvalidBonusNumber(bonusNumber);
    }

    @Test
    void 보너스번호_입력이_숫자가_아니면_예외발생() {
        // given
        String bonusNumber = "1000a";

        // when, then
        assertThrowOnInvalidBonusNumber(bonusNumber);
    }

    @Test
    void 보너스번호_입력이_int형_범위를_벗어나면_예외발생() {
        // given
        String bonusNumber = "10000000000000";

        // when, then
        assertThrowOnInvalidBonusNumber(bonusNumber);
    }

    @Test
    void 보너스번호_입력이_음수면_예외발생() {
        // given
        String bonusNumber = "-100000";

        // when, then
        assertThrowOnInvalidBonusNumber(bonusNumber);
    }

    @Test
    void 보너스번호_정상값_테스트() {
        // given
        String bonusNumber = "30";

        // when, then
        assertNotThrowsOnValidBonusNumber(bonusNumber);
    }

    private static void assertNotThrowsOnValidBonusNumber(String bonusNumber) {
        assertDoesNotThrow(() -> {
            Validator.validateBonusNumber(bonusNumber);
        });
    }

    private static void assertThrowOnInvalidBonusNumber(String bonusNumber) {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateBonusNumber(bonusNumber);
        });
    }
}
