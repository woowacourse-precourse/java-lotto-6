package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CommaSeparatedNumbersValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {",", "123,", ",123", " ", "", "12a,3", "23 ,45"})
    void validateDigitsWithCommaSeparatedToFail(String input) {
        assertThatThrownBy(() -> CommaSeparatedNumbersValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "23"})
    void validateDigitsWithCommaSeparatedToSuccess(String input) {
        assertDoesNotThrow(() -> CommaSeparatedNumbersValidator.validate(input));
    }
}
