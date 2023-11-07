package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumericValidatorTest {

    private static final String ERROR_MESSAGE = "[ERROR] ";

    @DisplayName("숫자 형식이 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"sdfjlvo14n", "121@fsh", "1,2,4", "-1,2,10.0"})
    void isNotNumeric_Then_ExceptionOccurs(final String stringNumber) {
        assertThatThrownBy(() -> NumericValidator.validate(stringNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
