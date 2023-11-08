package lotto.domain.model;

import lotto.constant.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverSize() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_COUNT_OF_VALUES);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_HAS_DUPLICATE_NUMBERS);
    }

    @DisplayName("당첨 번호 중 1~45의 범위에 속하지 않는 숫자가 존재하면 예외가 발생한다.")
    @Test
    void createWinningNumberByOutOfRangeNumber() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 65, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_OUT_OF_RANGES);
    }

    @DisplayName("입력된 보너스 번호가 당첨 번호에 존재하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void validateBonusNumberByDuplicateNumber(int bonusNumber) {
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1,2,3,4,5,6));

        assertThatThrownBy(() -> winningNumber.validateBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_CONTAIN_BONUS_NUMBER_IN_WINNING_NUMBER);
    }

    @DisplayName("입력된 보너스 번호가 당첨 번호에 존재하지 않으면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {7, 8, 9, 10, 11, 12})
    void validateBonusNumberByNonDuplicateNumber(int bonusNumber) {
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1,2,3,4,5,6));

        assertThatCode(() -> winningNumber.validateBonusNumber(bonusNumber))
                .doesNotThrowAnyException();
    }
}