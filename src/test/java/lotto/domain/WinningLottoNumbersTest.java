package lotto.domain;

import lotto.view.message.exception.BudgetInputErrorMessage;
import lotto.view.message.exception.WinningCombinationInputErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoNumbersTest {
    @DisplayName("입력된 당첨 숫자의 개수가 6개가 아닐 때 예외 발생")
    @Test
    void incorrectWinningNumbersSize() {
        String inputWinningNumbers = "1,2,3,34";
        assertThatThrownBy(() -> new WinningLottoNumbers(inputWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.INCORRECT_SIZE.getMessage());
    }

    @DisplayName("입력된 당첨 숫자가 범위를 벗어날 때 예외 발생")
    @Test
    void outOfRangeWinningNumbers(){
        String inputWinningNumbers = "1,2,3,4,5,500";
        assertThatThrownBy(() -> new WinningLottoNumbers(inputWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.OUT_OF_RANGE_NUMBER.getMessage());
    }

    @DisplayName("입력된 당첨 숫자가 중복일 때 예외 발생")
    @Test
    void isDuplidateWinningNumbers(){
        String inputWinningNumbers = "1,2,3,3,4,5";
        assertThatThrownBy(() -> new WinningLottoNumbers(inputWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.DUPLICATED_NUMBER.getMessage());
    }
}