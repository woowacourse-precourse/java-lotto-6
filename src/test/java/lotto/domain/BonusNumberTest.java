package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.enums.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @DisplayName("당첨 번호에 이미 있는 번호를 입력할 경우 예외가 발생한다.")
    @Test
    void validateExistInWinningNumber() {
        // given
        WinningNumber winningNumber = WinningNumber.from("1,2,3,4,5,6");

        // then
        assertThatThrownBy(() -> BonusNumber.ofNotDuplicatedWithWinningNumber("6", winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EXIST_IN_WINNING_NUMBER.getMessage());
    }

    @DisplayName("번호가 1 ~ 45 범위의 수를 넘으면 예외가 발생한다.")
    @Test
    void validateRange() {
        // given
        WinningNumber winningNumber = WinningNumber.from("1,2,3,4,5,6");

        // then
        assertThatThrownBy(() -> BonusNumber.ofNotDuplicatedWithWinningNumber("46", winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NUMBER_RANGE.getMessage());
    }
}