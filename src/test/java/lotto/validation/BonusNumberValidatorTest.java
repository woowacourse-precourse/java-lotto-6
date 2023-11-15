package lotto.validation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusNumberValidatorTest {
    @Test
    void 보너스번호_입력이_null이면_예외발생() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = null;

        // when, then
        assertThrowOnInvalidBonusNumber(lottoNumbers, bonusNumber);
    }

    @Test
    void 보너스번호_입력이_빈문자열이면_예외발생() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = "";

        // when, then
        assertThrowOnInvalidBonusNumber(lottoNumbers, bonusNumber);
    }

    @Test
    void 보너스번호_입력이_숫자가_아니면_예외발생() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = "1000a";

        // when, then
        assertThrowOnInvalidBonusNumber(lottoNumbers, bonusNumber);
    }

    @Test
    void 보너스번호_입력이_int형_범위를_벗어나면_예외발생() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = "10000000000000";

        // when, then
        assertThrowOnInvalidBonusNumber(lottoNumbers, bonusNumber);
    }

    @Test
    void 보너스번호_입력이_음수면_예외발생() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = "-100000";

        // when, then
        assertThrowOnInvalidBonusNumber(lottoNumbers, bonusNumber);
    }

    @Test
    void 보너스번호_정상값_테스트() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = "30";

        // when, then
        assertNotThrowsOnValidBonusNumber(lottoNumbers, bonusNumber);
    }

    private static void assertNotThrowsOnValidBonusNumber(
            List<Integer> lottoNumbers,
            String bonusNumber
    ) {
        assertDoesNotThrow(() -> {
            Validator.validateBonusNumber(lottoNumbers, bonusNumber);
        });
    }

    private static void assertThrowOnInvalidBonusNumber(
            List<Integer> lottoNumbers,
            String bonusNumber
    ) {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateBonusNumber(lottoNumbers, bonusNumber);
        });
    }
}
