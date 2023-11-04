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

    @ParameterizedTest
    @DisplayName("구입금액: 입력이 1000의 배수가 아닌 경우")
    @ValueSource(strings = {"1400", "900"})
    void whenInputIsNotDividedBy1000(String input) {
        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(input)
        );
    }

    @ParameterizedTest
    @DisplayName("구입금액: 입력이 음수인 경우")
    @ValueSource(strings = {"-5", "-9000"})
    void whenInputIsNegative(String input) {
        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(input)
        );
    }

    @ParameterizedTest
    @DisplayName("구입금액: 너무 큰 수가 들어왔을 경우")
    @ValueSource(strings = {"100000000000000000000000000000000000"})
    void whenInputIsTooBig(String input) {
        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(input)
        );
    }

    @ParameterizedTest
    @DisplayName("구입금액: 올바른 입력이 들어왔을 때")
    @ValueSource(strings = {"14000", "8000"})
    void whenInputIsValid(String input) {
        validator.validate(input);
    }
}
