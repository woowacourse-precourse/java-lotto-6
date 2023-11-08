package lotto;

import static lotto.constant.ErrorMessage.DUPLICATED_NUMBER_ERROR;
import static lotto.constant.ErrorMessage.INCORRECT_INPUT_COUNT;
import static lotto.constant.ErrorMessage.INDIVISIBLE_PRICE_ERROR;
import static lotto.constant.ErrorMessage.NUMBER_RANGE_ERROR;
import static lotto.constant.ErrorMessage.WRONG_TYPE_INPUT_ERROR;
import static lotto.constant.ErrorMessage.WRONG_TYPE_PRICE_ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import lotto.validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    @DisplayName("Integer 타입이 아닌 로또 구입 금액을 입력하면 예외가 발생한다.")
    @Test
    void inputWrongTypeBudget() {
        assertThatThrownBy(() -> InputValidator.validateBudget("123a4"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(WRONG_TYPE_PRICE_ERROR.getMessage());
    }

    @DisplayName("로또 구입 금액이 로또 가격으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void inputIndivisibleBudget() {
        assertThatThrownBy(() -> InputValidator.validateBudget("15450"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INDIVISIBLE_PRICE_ERROR.getMessage());
    }

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void inputWinningNumbersByOverSize() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumber("1,2,3,4,5,6,7"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INCORRECT_INPUT_COUNT.getMessage());
    }

    @DisplayName("Integer 타입이 아닌 당첨 번호를 입력하면 예외가 발생한다.")
    @Test
    void inputWrongTypeWinningNumbers() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumber("1,2,a,4,5,6"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(WRONG_TYPE_INPUT_ERROR.getMessage());
    }

    @DisplayName("범위를 벗어난 로또 번호를 입력하면 예외가 발생한다.")
    @Test
    void inputOuterRangeNumbers() {
        assertThatThrownBy(() -> InputValidator.validateRange(0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(NUMBER_RANGE_ERROR.getMessage());

        assertThatThrownBy(() -> InputValidator.validateRange(46))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(NUMBER_RANGE_ERROR.getMessage());
    }

    @DisplayName("중복된 당첨 번호 입력시 예외가 발생한다.")
    @Test
    void inputDuplicatedNumbers() {
        assertThatThrownBy(
            () -> InputValidator.validateDuplicate(Arrays.asList("1", "5", "7", "12", "5", "37")))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(DUPLICATED_NUMBER_ERROR.getMessage());
    }

    @DisplayName("입력받은 보너스 번호가 당첨 번호와 중복될 때 예외가 발생한다.")
    @Test
    void inputDuplicatedBonusNumber() {
        assertThatThrownBy(
            () -> InputValidator.validateBonusNumber("9", Arrays.asList(1, 5, 7, 12, 9, 37)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(DUPLICATED_NUMBER_ERROR.getMessage());
    }
}
