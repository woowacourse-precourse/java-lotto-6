package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void winningNumbersCount() {
        String input = "1,2,3,4,5,6,7";
        assertThatThrownBy(() -> Validator.validWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.incorrectCountError);
    }

    @DisplayName("당첨 번호 중 숫자가 아닌 값이 있는 경우 예외가 발생한다.")
    @Test
    void nonNumericWinningNumbers() {
        String input = "1,a,3,4,5,6";
        assertThatThrownBy(() -> Validator.validWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.nonNumericInputError);
    }

    @DisplayName("당첨 번호 중 범위가 1~45가 아닌 경우 예외가 발생한다.")
    @Test
    void outOfRangeWinningNumbers() {
        String input = "1,2,0,4,5,6";
        assertThatThrownBy(() -> Validator.validWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.outOfRangeError);
    }

    @DisplayName("중복된 당첨 번호가 존재하는 경우 예외가 발생한다.")
    @Test
    void duplicateWinningNumbers() {
        String input = "1,2,3,3,4,5";
        assertThatThrownBy(() -> Validator.validWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.duplicateNumberError);
    }
}
