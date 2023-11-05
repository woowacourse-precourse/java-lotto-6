package lotto.services;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ExceptionHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {

    @DisplayName("보너스 번호가 1부터 45사이 숫자가 아닐 때 예외가 발생한다.")
    @Test
    void createBonusNumberNotBetween1And45() {
        assertThatThrownBy(() -> new Bonus().createBonusNumber("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionHandler.OUT_OF_RANGE);
    }

    @DisplayName("보너스 번호가 1개가 아닐 때 예외가 발생한다.")
    @Test
    void createBonusNumberNoLengthOfOne() {
        assertThatThrownBy(() -> new Bonus().createBonusNumber("1,2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionHandler.NO_LENGTH_OF_ONE);
    }
}