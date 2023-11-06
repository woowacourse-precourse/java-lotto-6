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
}
