package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    @DisplayName("정수가 아닌 문자열을 입력할 경우 예외를 발생시킨다.")
    @Test
    void validateDigit() {
        String str = "1cd";
        assertThatThrownBy(() -> Validator.validateDigit(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000단위가 아닐 경우 예외를 발생시킨다.")
    @Test
    void validateAmountInThousands() {
        int amount = 1234;
        assertThatThrownBy(() -> Validator.validateAmountInThousands(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0 미만일 경우 에러를 발생시킨다.")
    @Test
    void validateOverZero() {
        int amount = -10;
        assertThatThrownBy(() -> Validator.validateOverZero(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
