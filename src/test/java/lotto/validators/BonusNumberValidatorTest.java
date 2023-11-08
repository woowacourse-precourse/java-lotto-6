package lotto.validators;

import static lotto.constant.ErrorMessage.INPUT_BONUS_NUMBER_IN_WINNING_NUMBERS;
import static lotto.constant.ErrorMessage.INPUT_BONUS_NUMBER_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberValidatorTest {
    @Test
    @DisplayName("보너스 번호가 범위 내의 값이 아니라면 예외가 발생한다.")
    void validBonusNumberInRange() {
        // given
        Integer bonusNumber = 50;

        // when & then
        assertThatThrownBy(() -> BonusNumberValidator.validBonusNumberInRange(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_BONUS_NUMBER_OUT_OF_RANGE);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    void validBonusNumberInWinningNumbers() {
        // given
        Integer bonusNumber = 5;
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when & then
        assertThatThrownBy(
                () -> BonusNumberValidator.validBonusNumberInWinningNumbers(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_BONUS_NUMBER_IN_WINNING_NUMBERS);
    }
}
