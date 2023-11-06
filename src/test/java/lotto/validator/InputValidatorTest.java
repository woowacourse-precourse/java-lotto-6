package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    private InputValidator inputValidator = new InputValidator();

    @Test
    void validatePriceWithValidPrice() {
        String input = "8000";

        assertThatCode(() -> inputValidator.validatePrice(input))
            .doesNotThrowAnyException();
    }

    @Test
    void validatePriceWithNonInteger() {
        String input = "alpha";

        assertThatThrownBy(() -> inputValidator.validatePrice(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validatePriceWithNegativeInteger() {
        String input = "-8000";

        assertThatThrownBy(() -> inputValidator.validatePrice(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validatePriceWithNonMultipleOfThousand() {
        String input = "1500";

        assertThatThrownBy(() -> inputValidator.validatePrice(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateWinningNumber() {
        String winningNumberInput = "1,2,3,4,5,6";
        String bonusNumberInput = "7";

        assertThatCode(() -> inputValidator.validateWinningNumber(winningNumberInput, bonusNumberInput))
            .doesNotThrowAnyException();
    }

    @Test
    void notCorrectLength() {
        String winningNumberInput = "1,2,3,4";
        String bonusNumberInput = "8";

        assertThatThrownBy(() -> inputValidator.validateWinningNumber(winningNumberInput, bonusNumberInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("6개의 숫자가 아닙니다");
    }

    @Test
    void winningNumberDuplicate() {
        String winningNumberInput = "1,2,3,4,5,5";
        String bonusNumberInput = "8";

        assertThatThrownBy(() -> inputValidator.validateWinningNumber(winningNumberInput, bonusNumberInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복 숫자가 존재합니다.");
    }

    @Test
    void winningNumberDuplicateByBonusNumber() {
        String winningNumberInput = "1,2,3,4,5,6";
        String bonusNumberInput = "6";

        assertThatThrownBy(() -> inputValidator.validateWinningNumber(winningNumberInput, bonusNumberInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("당첨 번호와 보너스 번호가 중복입니다.");
    }

    @Test
    void winningNumberOutOfRange() {
        String winningNumberInput = "1,2,3,4,5,66";
        String bonusNumberInput = "6";

        assertThatThrownBy(() -> inputValidator.validateWinningNumber(winningNumberInput, bonusNumberInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("번호가 범위를 벗어났습니다.");
    }

    @Test
    void bonusNumberOutOfRange() {
        String winningNumberInput = "1,2,3,4,5,6";
        String bonusNumberInput = "66";

        assertThatThrownBy(() -> inputValidator.validateWinningNumber(winningNumberInput, bonusNumberInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("번호가 범위를 벗어났습니다.");
    }
}
