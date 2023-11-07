package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validator.InputValidator;

public class InputValidatorTest {

    @DisplayName("로또 구입 금액이 숫자가 아닌 값이 입력되면 에러가 발생한다.")
    @Test
    void validateNotNumberPurchaseAmountTest() {
        String input = "kkkk";
        Assertions.assertThatThrownBy(() -> InputValidator.validatePurchaseAmountInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1000 단위가 아니면 에러가 발생한다.")
    @Test
    void validateNotMultipleOf1000PurchaseAmountTest() {
        String input = "1001";
        Assertions.assertThatThrownBy(() -> InputValidator.validatePurchaseAmountInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개가 아니라면 에러가 발생한다.")
    @Test
    void validateNumberOfWinningNumbers() {
        String input = "1,2,3,4,5";
        Assertions.assertThatThrownBy(() -> InputValidator.validateWinningNumbersInput(input));
    }

    @DisplayName("당첨 번호에 숫자가 아닌 값이 주어진다면 에러가 발생한다.")
    @Test
    void validateAllNumericNumbersInWinningNumbers() {
        String input = "1,2,3,4,5,k";
        Assertions.assertThatThrownBy(() -> InputValidator.validateWinningNumbersInput(input));
    }

    @DisplayName("당첨 번호중 번호가 중복되면 에러가 발생한다.")
    @Test
    void validateDuplicateWinningNumbers() {
        String input = "1,2,3,4,5,5";
        Assertions.assertThatThrownBy(() -> InputValidator.validateWinningNumbersInput(input));
    }

    @DisplayName("당첨 번호가 6개 중 범위를 벗어난 숫자가 있다면 에러가 발생한다.")
    @Test
    void validateWinningNumbersInRange() {
        String input = "0,2,3,4,5,6";
        Assertions.assertThatThrownBy(() -> InputValidator.validateWinningNumbersInput(input));
        String secondInput = "1,2,3,4,5,46";
        Assertions.assertThatThrownBy(() -> InputValidator.validateWinningNumbersInput(secondInput));
    }
}
