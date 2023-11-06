package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AssertException {
    public static void assertExceptionTest(Validator<String> validator, String input, String message) {
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(message);
    }
}
