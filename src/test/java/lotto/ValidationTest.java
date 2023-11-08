package lotto;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static lotto.Validation.*;
class ValidationTest {
    @DisplayName("금액 입력 시 문자가 입력되면 예외가 발생한다.")
    @Test
    void checkValidateInteger() {
        assertThatThrownBy(() -> validateMoney("?"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.INPUT_NUMBER_EXCEPTION_MSG);
    }

    @DisplayName("금액 입력 시 1000으로 나눠지지 않는 숫자가 입력되면 예외가 발생한다.")
    @Test
    void checkValidateDivideBy1000() {
        assertThatThrownBy(() -> validateMoney("1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.INPUT_NOT_DIVIDE_EXCEPTION_MSG);
    }

    @DisplayName("당첨 번호의 구분자가 ,이 아니면 예외가 발생한다.")
    @Test
    void checkValidateWinningNumber() {
        assertThatThrownBy(() -> validateWinningNumber("1.2.3.4.5.6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.INPUT_DIVISION_EXCEPTION_MSG);
    }

    @DisplayName("당첨 번호가 6개가 입력되지 않으면 예외가 발생한다.")
    @Test
    void checkValidateNumberCount() {
        assertThatThrownBy(() -> validateWinningNumber("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.INPUT_WINNING_NUMBER_COUNT_EXCEPTION_MSG);
    }

    @DisplayName("당첨 번호에 문자가 입력되면 예외가 발생한다.")
    @Test
    void checkValidateIntegers() {
        assertThatThrownBy(() -> validateWinningNumber("1,2,3,4,5,?"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.INPUT_NUMBER_EXCEPTION_MSG);
    }

    @DisplayName("당첨 번호 중에 1 ~ 45 이외의 숫자가 입력되면 예외가 발생한다.")
    @Test
    void checkValidateNumbersRange() {
        assertThatThrownBy(() -> validateWinningNumber("1,2,3,4,5,100"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.INPUT_NUMBER_RANGE_EXCEPTION_MSG);
    }

    @DisplayName("당첨 번호 중에 중복된 숫자가 입력되면 예외가 발생한다.")
    @Test
    void checkValidateWinningNumberUnique() {
        assertThatThrownBy(() -> validateWinningNumber("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.INPUT_WINNING_NUMBER_UNIQUE_EXCEPTION_MSG);
    }

    @DisplayName("보너스 번호 중에 당첨 번호가 입력되면 예외가 발생한다.")
    @Test
    void checkValidateBonusNumberUnique() {
        assertThatThrownBy(() -> validateBonusNumber("1", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.INPUT_BONUS_NUMBER_UNIQUE_EXCEPTION_MSG);
    }

}