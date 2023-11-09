package lotto.io.input;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputValidatorTest {
    final InputValidator inputValidator = new InputValidator();

    @Test
    void validate_Numeric() {
        //given
        final String input = "aa";

        //when & then
        assertThatThrownBy(() -> inputValidator.validateNumeric(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void validate_numeric_without_exception() {
        //given
        final String input = "1";

        //when & then
        assertThatNoException().isThrownBy(() -> inputValidator.validateNumeric(input));
    }

    @Test
    void validate_null() {
        //given
        final String input = null;

        //when & then
        assertThatThrownBy(() -> inputValidator.validateNull(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void validate_null_without_exception() {
        //given
        final String input = "1";

        //when & then
        assertThatNoException().isThrownBy(() -> inputValidator.validateNull(input));
    }

    @Test
    void validate_have_not_delimiter() {
        //given
        final String input = "1";

        //when & then
        assertThatThrownBy(() -> inputValidator.validateHasDelimiter(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void validate_have_not_delimiter_without_exception() {
        //given
        final String input = "1,2,3,4,5,6";

        //when & then
        assertThatNoException().isThrownBy(() -> inputValidator.validateHasDelimiter(input));
    }
}