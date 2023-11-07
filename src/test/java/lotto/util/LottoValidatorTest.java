package lotto.util;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 4000})
    @DisplayName("유효한 구입금액 유효성 검증")
    void validatePurchaseAmount_유효한_구입금액(Integer input) {
        LottoValidator.validatePurchaseAmount(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {999, 1500, 2001, -1000, 0})
    @DisplayName("유효하지 않은 구입금액 유효성 검증 시 예외 발생")
    void validatePurchaseAmount_유효하지_않은_구입금액(Integer input) {
        assertThrows(IllegalArgumentException.class, () -> {
            LottoValidator.validatePurchaseAmount(input);
        });
    }

    @Test
    void validateWinningNumber() {
    }

    @Test
    void validateBonusNumber() {
    }
}