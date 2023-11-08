package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validator.InputDataValidator;

public class WinningNumberTest {

    InputDataValidator inputDataValidator = new InputDataValidator();

    @DisplayName("당첨 번호가 6자리가 아니면 예외가 발생한다.")
    @Test
    void checkWinningNumberSize() {
        String[] winningNumber = {"1", "2", "3", "4", "5", "6", "7"};
        assertThatThrownBy(() -> inputDataValidator.validWinningNumberSize(winningNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 중 숫자가 아닌 데이터가 있으면 예외가 발생한다.")
    @Test
    void checkIsNumericWinningNumber() {
        String[] winningNumber = {"1", "2", "3", "4", "5", "6a"};
        assertThatThrownBy(() -> inputDataValidator.validWinningNumberInput(winningNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 중 45초과인 숫자가 있으면 예외가 발생한다.")
    @Test
    void checkMaxWinningNumber() {
        String[] winningNumber = {"1", "2", "3", "4", "5", "55"};
        assertThatThrownBy(() -> inputDataValidator.validMaxMinWinningNumber(winningNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 중 1미만인 숫자가 있으면 예외가 발생한다.")
    @Test
    void checkMinWinningNumber() {
        String[] winningNumber = {"0", "2", "3", "4", "5", "6"};
        assertThatThrownBy(() -> inputDataValidator.validMaxMinWinningNumber(winningNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 중 중복 된 숫자가 있으면 예외가 발생한다.")
    @Test
    void checkDuplicateWinningNumber() {
        String[] winningNumber = {"1", "2", "3", "4", "5", "5"};
        assertThatThrownBy(() -> inputDataValidator.validDuplicateWinningNumber(winningNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
