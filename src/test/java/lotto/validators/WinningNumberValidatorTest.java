package lotto.validators;

import static lotto.constant.ErrorMessage.INPUT_WINNING_NUMBER_COUNT_IS_INCORRECT;
import static lotto.constant.ErrorMessage.INPUT_WINNING_NUMBER_DUPLICATED;
import static lotto.constant.ErrorMessage.INPUT_WINNING_NUMBER_VALUE_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
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

    @Test
    @DisplayName("로또 당첨 번호가 범위 내의 값이 아니라면 예외가 발생한다.")
    void validWinningNumberValueInRange() {
        // given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 50);

        // when & then
        assertThatThrownBy(
                () -> WinningNumberValidator.validWinningNumberValueInRange(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_WINNING_NUMBER_VALUE_OUT_OF_RANGE);
    }

    @Test
    @DisplayName("로또 당첨 번호가 중복된 값을 가지는 경우 예외가 발생한다.")
    void validWinningNumberDuplicated() {
        // given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 6, 6);

        // when & then
        assertThatThrownBy(
                () -> WinningNumberValidator.validWinningNumberDuplicated(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_WINNING_NUMBER_DUPLICATED);
    }
}
