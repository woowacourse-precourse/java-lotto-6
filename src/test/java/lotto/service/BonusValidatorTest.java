package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusValidatorTest {
    @DisplayName("보너스 번호 테스트")
    @Test
    void testBonus() {
        assertThat(BonusValidator.validate("1")).isEqualTo(1);
    }

    @DisplayName("보너스 번호 예외 테스트")
    @Test
    void testBonusException() {
        assertThatThrownBy(() -> BonusValidator.validate("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(UserNumbersValidateStatus.LOTTO_NUMBERS_ERROR.get());
    }

    @DisplayName("보너스 번호 예외 테스트")
    @Test
    void testBonusException2() {
        assertThatThrownBy(() -> BonusValidator.validate("46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(UserNumbersValidateStatus.LOTTO_NUMBERS_ERROR.get());
    }
}
