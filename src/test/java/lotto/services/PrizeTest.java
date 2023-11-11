package lotto.services;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ExceptionHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {

    @DisplayName("당첨 번호가 1부터 45사이의 숫자가 아닐 때 예외가 발생한다.")
    @Test
    void createPrizeNumberNotBetween1And45() {
        assertThatThrownBy(() -> new Prize().createPrizeNumber("1,2,3,4,5,66"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionHandler.OUT_OF_RANGE);
    }

    @DisplayName("당첨 번호가 6개가 아닐 때 예외가 발생한다.")
    @Test
    void createPrizeNumberNoLengthOfSix() {
        assertThatThrownBy(() -> new Prize().createPrizeNumber("1,2,3,4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionHandler.NO_LENGTH_OF_SIX);

    }

    @DisplayName("당첨 번호에 중복된 숫자가 있을 때 예외가 발생한다.")
    @Test
    void createPrizeNumberInDuplicate() {
        assertThatThrownBy(() -> new Prize().createPrizeNumber("1,2,2,3,3,4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionHandler.NUMBER_IN_DUPLICATE);
    }
}