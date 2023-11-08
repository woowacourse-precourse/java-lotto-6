package lotto.util.validator;

import lotto.util.validator.constant.ErrorMessageConstant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningInputValidatorTest {
    private static final InputValidator winningInputValidator = new WinningInputValidator();

    @DisplayName("당첨 번호 입력 개수가 6개가 넘어갈 경우 예외가 발생한다.")
    @Test
    void inputWinningNumberOverBySize() {
        //given
        String values = "1,2,3,4,5,6,7";

        //when,then
        Assertions.assertThatThrownBy(() -> winningInputValidator.validate(values))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.WINNING_LENGTH_NOT_SIX_MESSAGE.getMessage());
    }

    @DisplayName("당첨 번호 입력 개수가 6개 미만일 경우 예외가 발생한다.")
    @Test
    void inputWinningNumbersUnderBySize() {
        //given
        String values = "1,2,3,4,5";

        //when,then
        Assertions.assertThatThrownBy(() -> winningInputValidator.validate(values))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.WINNING_LENGTH_NOT_SIX_MESSAGE.getMessage());
    }

    @DisplayName("당첨 번호에 숫자 이외의 값이 들어가있을 경우 예외가 발생한다.")
    @Test
    void inputWinningNumbersNotNumber() {
        //given
        String values = "1,w,2,3,4,5";

        //when,then
        Assertions.assertThatThrownBy(() -> winningInputValidator.validate(values))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.WINNING_NUMBER_IS_NOT_NUMERIC.getMessage());
    }

    @DisplayName("당첨 번호들이 45보다 큰 경우 예외가 발생한다.")
    @Test
    void inputWinningNumbersOverByRange() {
        //given
        String values = "1,2,3,4,5,67";

        //when,then
        Assertions.assertThatThrownBy(() -> winningInputValidator.validate(values))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.WINNING_NUMBER_RANGE_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("당첨 번호들이 1보다 작은 경우 예외가 발생한다.")
    @Test
    void inputWinningNumbersUnderByRange() {
        //given
        String values = "1,2,3,4,5,0";

        //when,then
        Assertions.assertThatThrownBy(() -> winningInputValidator.validate(values))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.WINNING_NUMBER_RANGE_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("당첨 번호들이 중복된 값이 있을 경우 예외가 발생한다.")
    @Test
    void inputWinningNumbersHaveDuplicated() {
        //given
        String values = "1,2,3,4,5,5";

        //when,then
        Assertions.assertThatThrownBy(() -> winningInputValidator.validate(values))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.WINNING_NUMBER_DUPLICATE_MESSAGE.getMessage());
    }
}