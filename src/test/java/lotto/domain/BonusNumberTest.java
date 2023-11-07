package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    @DisplayName("보너스 숫자가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createBonusNumberByOutOfRange() {
        int zero = 0;
        int negative = -10;
        int overRange = 50;

        assertThatThrownBy(() -> new BonusNumber(zero))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BonusNumber(negative))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BonusNumber(overRange))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자를 성공적으로 생성한다")
    @Test
    void createBonusNumberSuccessfully() {
        int validNumber = 7;

        Assertions.assertAll(() -> new BonusNumber(validNumber));
    }

    @DisplayName("보너스 숫자와 숫자값에 대한 비교가 이루어진다")
    @Test
    void compareBonusNumber() {
        int validNumber = 7;

        BonusNumber bonusNumber = new BonusNumber(validNumber);
        Assertions.assertTrue(bonusNumber.equals(validNumber));
    }


}
