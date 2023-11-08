package lotto.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-1000", "-100"})
    public void 입력값이_양수인지_검증(String input) {
        assertThatThrownBy(() -> Validator.getValidatedMoney(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_POSITIVE_INTEGER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"3500", "400", "6700"})
    public void 입력값이_1000원_단위인지_검증(String input) {
        assertThatThrownBy(() -> Validator.getValidatedMoney(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_PROPER_DENOMINATION.getMessage());
    }
}
