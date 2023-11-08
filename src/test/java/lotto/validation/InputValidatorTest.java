package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @DisplayName("빈 값을 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void validateNull(String input) {
        assertThatThrownBy(() -> InputValidator.validatePurchasePrice(input))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputValidator.validateWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputValidator.validateBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매가격과 보너스 번호에 숫자가 아닌 값을 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-10", "a"})
    void validateIsNumber(String input) {
        assertThatThrownBy(() -> InputValidator.validatePurchasePrice(input))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputValidator.validateBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("쉼표로 구분된 당첨번호 중 숫자가 아닌 값이 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,a", "!,2,3,4,5,6"})
    void validateIsNumberSeparatedByComma(String input) {
        assertThatThrownBy(() -> InputValidator.validateWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호의 구분자로 쉼표를 사용하지 않으면 예외가 발생한다.")
    @Test
    void validateSeparator() {
        // given
        String input = "123456";

        // then
        assertThatThrownBy(() -> InputValidator.validateWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("쉼표로 구분된 당첨번호 중 빈 값이 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {",1,2,3,4,5", "1,2,3,4,,6"})
    void validateContainsBlank(String input) {
        assertThatThrownBy(() -> InputValidator.validateWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}