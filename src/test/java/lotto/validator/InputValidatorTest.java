package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.message.ErrorMessage;
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

        assertThatCode(() -> inputValidator.validateWinningNumber(winningNumberInput))
            .doesNotThrowAnyException();
    }

    @Test
    void notCorrectLength() {
        String winningNumberInput = "1,2,3,4";

        assertThatThrownBy(() -> inputValidator.validateWinningNumber(winningNumberInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.PREFIX.getErrorMessage() +
                ErrorMessage.NOT_LENGTH_SIX.getErrorMessage());
    }

    @Test
    void winningNumberDuplicate() {
        String winningNumberInput = "1,2,3,4,5,5";

        assertThatThrownBy(() -> inputValidator.validateWinningNumber(winningNumberInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.PREFIX.getErrorMessage() +
                ErrorMessage.HAS_DUPLICATED_NUMBER.getErrorMessage());
    }

    @Test
    void winningNumberDuplicateByBonusNumber() {
        String winningNumberInput = "1,2,3,4,5,6";
        Set<Integer> winningNumber = Arrays.stream(winningNumberInput.split(","))
                                            .map(Integer::parseInt)
                                            .collect(Collectors.toSet());
        int bonusNumber = 6;

        assertThatThrownBy(() -> inputValidator.validateBonusNumberNotDuplicate(winningNumber, bonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.PREFIX.getErrorMessage() +
                ErrorMessage.HAS_DUPLICATED_WINNING_NUMBER_WITH_BONUS_NUMBER.getErrorMessage());
    }

    @Test
    void winningNumberOutOfUpperRange() {
        String winningNumberInput = "1,2,3,4,5,66";

        assertThatThrownBy(() -> inputValidator.validateWinningNumber(winningNumberInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.PREFIX.getErrorMessage() +
                ErrorMessage.OUT_OF_RANGE.getErrorMessage());
    }

    @Test
    void winningNumberOutOfLowerRange() {
        String winningNumberInput = "-1,2,3,4,5,6";

        assertThatThrownBy(() -> inputValidator.validateWinningNumber(winningNumberInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.PREFIX.getErrorMessage() +
                ErrorMessage.OUT_OF_RANGE.getErrorMessage());
    }

    @Test
    void bonusNumberOutOfRange() {
        String bonusNumberInput = "66";

        assertThatThrownBy(() -> inputValidator.validateBonusNumber(bonusNumberInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.PREFIX.getErrorMessage() +
                ErrorMessage.OUT_OF_RANGE.getErrorMessage());
    }
}
