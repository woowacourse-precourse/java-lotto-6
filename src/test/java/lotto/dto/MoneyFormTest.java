package lotto.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyFormTest {

    @ValueSource(strings = {"만원", "10$", "1000₩"})
    @ParameterizedTest
    void validateNumberFormatTest(String input) {
        Assertions.assertThatThrownBy(() -> new MoneyForm(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
