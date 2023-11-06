package lotto.validator;

import static lotto.enums.ErrorMassage.IS_BLANK;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    private final InputValidator validator = new InputValidator();

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void 값이_비어있을_경우_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> validator.validateBlank(input))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(IS_BLANK.getMassage());
    }
}