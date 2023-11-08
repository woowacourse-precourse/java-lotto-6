package lotto.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberInputValidatorTest {

    private static InputValidator validator;

    @BeforeAll
    private static void beforeAll() {
        validator = new NumberInputValidator();
    }

    @ParameterizedTest
    @DisplayName("보너스번호: 입력이 숫자가 아닌경우")
    @ValueSource(strings = {"14a", "one"})
    void whenInputIsNotNumber(String input) {
        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(input)
        );
    }

    @ParameterizedTest
    @DisplayName("보너스번호: 입력이 1 과 45 사이가 아닌 경우")
    @ValueSource(strings = {"0", "46"})
    void whenInputIsSmallerThan1OrBiggerThan45(String input) {
        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(input)
        );
    }

    @ParameterizedTest
    @DisplayName("보너스번호: 입력이 너무 커서 parseInt 가 안되는 경우")
    @ValueSource(strings = {"1000000000000"})
    void whenInputIsTooLarge(String input) {
        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(input)
        );
    }

    @ParameterizedTest
    @DisplayName("보너스번호: 입력이 올바른 경우")
    @ValueSource(strings = {"5"})
    void whenInputIsValid(String input) {
        validator.validate(input);
    }
}