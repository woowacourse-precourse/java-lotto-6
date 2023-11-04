package lotto.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AmountValidatorTest {

    private static Validator validator;

    @BeforeAll
    private static void beforeAll() {
        validator = new AmountValidator();
    }

    @ParameterizedTest
    @DisplayName("구입금액: 입력이 숫자가 아닐 경우")
    @ValueSource(strings = {"a", "천원"})
    void whenInputIsNotNumber(String input) {
        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(input)
        );
    }

}
