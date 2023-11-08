package lotto.validators;

import static lotto.constant.ErrorMessage.INPUT_WINNING_NUMBER_COUNT_IS_INCORRECT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberValidatorTest {
    @Test
    @DisplayName("로또 당첨 번호 개수가 6개가 아닌 경우 예외가 발생한다.")
    void validWinningNumbersCount() {
        // given
        String[] winningNumbers = new String[]{"1","2","3"};

        // when & then
        assertThatThrownBy(
                () -> WinningNumberValidator.validWinningNumberCount(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_WINNING_NUMBER_COUNT_IS_INCORRECT);
    }
}
