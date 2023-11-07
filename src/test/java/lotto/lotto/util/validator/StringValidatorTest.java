package lotto.lotto.util.validator;

import lotto.util.validator.StringValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringValidatorTest {
    @DisplayName("리스트에 숫자가 아닌 값이 포함되면 예외를 던진다.")
    @Test
    void validateNotOnlyNumber() {
        assertThatThrownBy(() -> StringValidator.validateOnlyNumber(List.of("123", "456", "ffas2")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("리스트에 숫자만 포함되어야 한다.")
    @Test
    void validateOnlyNumber() {
        Assertions.assertDoesNotThrow(() ->
                StringValidator.validateOnlyNumber(List.of("123", "456", "789")));
    }

    @DisplayName("숫자가 아닌 값이 포함되면 예외를 던진다.")
    @Test
    void validateNonDigitString() {
        assertThatThrownBy(() -> StringValidator.validateOnlyNumber("1234f"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자만 포함되어야 한다.")
    @Test
    void validateDigitString() {
        Assertions.assertDoesNotThrow(() ->
                        StringValidator.validateOnlyNumber("1"));
    }

    @DisplayName("값을 입력하지 않으면 예외를 던진다.")
    @Test
    void validateBlank() {
        assertThatThrownBy(() -> StringValidator.validateNotBlank("    "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("값을 입력하지 않으면 예외를 던진다.")
    @Test
    void validateNotBlank() {
        Assertions.assertDoesNotThrow(() ->
                StringValidator.validateNotBlank("123"));
    }
}
