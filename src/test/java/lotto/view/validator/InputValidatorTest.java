package lotto.view.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력이 null 이거나 공백이면 예외가 발생한다.")
    void validateInput(String input) {
        assertThatThrownBy(() -> InputValidator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 공백일 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "!", "12A"})
    @DisplayName("구입 금액에 대한 입력이 숫자가 아니면 예외가 발생한다.")
    void validatePurchaseAmount(String input) {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액에 대한 입력은 숫자만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,a", "1,!", "12A"})
    @DisplayName("당첨 번호에 대한 입력 형식이 올바르지 않으면 예외가 발생한다.")
    void validateWinningNumbers(String input) {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호에 대한 입력 형식이 올바르지 않습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "!", "12A"})
    @DisplayName("보너스 번호에 대한 입력이 숫자가 아니면 예외가 발생한다.")
    void validateBonusNumber(String input) {
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호에 대한 입력은 숫자만 가능합니다.");
    }
}