package lotto.validator;

import static lotto.enums.ErrorMessage.CONTAIN_SPACE;
import static lotto.enums.ErrorMessage.IS_BLANK;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    private final InputValidator validator = new InputValidator();

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void 값이_비어있을_경우_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> validator.validate(input))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(IS_BLANK.getMassage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 ", "2,3,4 ", " 5", "30, 35, 40", " 15, 16,17"})
    void 값에_공백이_포함되어_있을_경우_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> validator.validate(input))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(CONTAIN_SPACE.getMassage());
    }
}