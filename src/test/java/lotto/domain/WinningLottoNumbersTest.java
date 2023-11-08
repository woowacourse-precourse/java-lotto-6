package lotto.domain;

import lotto.view.message.exception.WinningCombinationInputErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoNumbersTest {
    @DisplayName("입력된 당첨 숫자의 개수가 6개가 아닐 때 예외 발생")
    @Test
    void createIncorrectWinningNumbersSize() {
        String inputWinningNumbers = "1,2,3,34";
        assertThatThrownBy(() -> new WinningLottoNumbers(inputWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.INCORRECT_SIZE.getMessage());
    }

    @DisplayName("입력된 당첨 숫자가 범위를 벗어날 때 예외 발생")
    @Test
    void createOutOfRangeWinningNumbers(){
        String inputWinningNumbers = "1,2,3,4,5,500";
        assertThatThrownBy(() -> new WinningLottoNumbers(inputWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.OUT_OF_RANGE_NUMBER.getMessage());
    }

    @DisplayName("입력된 당첨 숫자가 중복일 때 예외 발생")
    @Test
    void createCheckDuplicateWinningNumbers(){
        String inputWinningNumbers = "1,2,3,3,4,5";
        assertThatThrownBy(() -> new WinningLottoNumbers(inputWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.DUPLICATED_NUMBER.getMessage());
    }
}