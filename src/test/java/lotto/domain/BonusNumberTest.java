package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.NumberOutOfRangeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    private static final int zero = 0, negative = -1, overRange = 46, validNumber = 7;

    @DisplayName("보너스 숫자가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createBonusNumberByOutOfRange() {
        assertThatThrownBy(() -> new BonusNumber(zero))
                .isInstanceOf(NumberOutOfRangeException.class);
        assertThatThrownBy(() -> new BonusNumber(negative))
                .isInstanceOf(NumberOutOfRangeException.class);
        assertThatThrownBy(() -> new BonusNumber(overRange))
                .isInstanceOf(NumberOutOfRangeException.class);
    }

    @DisplayName("보너스 숫자를 성공적으로 생성한다")
    @Test
    void createBonusNumberSuccessfully() {
        Assertions.assertAll(() -> new BonusNumber(validNumber));
    }

    @DisplayName("보너스 숫자와 숫자값에 대한 비교가 이루어진다")
    @Test
    void compareBonusNumber() {
        BonusNumber bonusNumber = new BonusNumber(validNumber);
        Assertions.assertTrue(bonusNumber.equals(validNumber));
    }


}
