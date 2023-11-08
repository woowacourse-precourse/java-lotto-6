package lotto.model;

import lotto.util.validator.constant.ErrorMessageConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    @Test
    void bonusNumberDuplicateToWinningNumber() {
        //given
        WinningNumber winningNumber = new WinningNumber(List.of(1,2,3,4,5,6));

        //when,then
        assertThatThrownBy(() -> new BonusNumber(5, winningNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.BONUS_NUMBER_DUPLICATE_WINNING_NUMBER.getMessage());
    }
}