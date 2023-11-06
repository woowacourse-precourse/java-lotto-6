package lotto.domain.util.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputValidatorTest {
    private static final String ERRER_MESSAGE = "[ERROR] ";

    @DisplayName("정상적인 경우")
    @Nested
    class 정상 {
        @DisplayName("정상적인 수 입력")
        @Test
        void validateNumber_1입력() {
            String number = "1";
            assertDoesNotThrow(() -> InputValidator.validateNumber(number));
        }

        @DisplayName("정상적인 숫자들 입력")
        @Test
        void validateNumberOrComma_1부터_6까지_수_입력() {
            String numbers = "1,2,3,4,5,6";
            assertDoesNotThrow(() -> InputValidator.validateNumberOrComma(numbers));
        }
    }

    @DisplayName("예외 상황")
    @Nested
    class 예외_상황 {
        @ParameterizedTest
        @CsvSource({
                "``",
                "` `",
                "`a`",
                "`1a`",
                "`1 2`"
        })
        void validateNumber_예외(String input) {
            assertThatThrownBy(() -> InputValidator.validateNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERRER_MESSAGE + "수를 입력해야 합니다.");
        }

        @ParameterizedTest
        @CsvSource({
                "`1,a`",
                "`1 2 3 4 5 6`",
                "`1;2;3;4;5;6`",
                "`123`",
                "`1,2,3,,4,5,6`"
        })
        void validateNumberOrComma_예외(String input) {
            assertThatThrownBy(() -> InputValidator.validateNumberOrComma(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERRER_MESSAGE + "당첨 번호를 쉼표로 구분하여 입력해야 합니다.");
        }
    }
}