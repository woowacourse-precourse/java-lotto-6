package lotto.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constants.ExceptionMessage;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.Test;

class InputBonusNumValidatorTest {

    @Test
    void Winning_Number와_겹치는_경우() {
        // given
        String winning = "1,2,3,4,5,6";
        WinningNumber winningNumber = WinningNumber.consistOf(winning);

        String bonus = "4";

        assertThatThrownBy(() -> InputValidator.validateBonusNumber(bonus, winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.BONUS_DUPLICATE_ERROR.getMessage());
    }
}