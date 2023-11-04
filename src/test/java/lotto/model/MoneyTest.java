package lotto.model;

import static lotto.exception.ExceptionMessage.NEGATIVE_NUMBER_EXCEPTION;
import static lotto.exception.ExceptionMessage.NUMBER_FORMAT_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @Test
    @DisplayName("올바른 값이 입력될 시 정상적으로 돈이 생성된다.")
    void validMoneyInputTest() {
        // given
        String moneyInput = "5000";

        // when & then
        assertDoesNotThrow(() -> Money.from(moneyInput));
    }

    @Nested
    @DisplayName("돈 입력 예외처리 검증")
    class MoneyExceptionTest {

        @Test
        @DisplayName("음수 입력 시 돈이 생성되지 않는다.")
        void negativeMoneyInputTest() {
            // given
            String moneyInput = "-20";

            // when & then
            assertThatThrownBy(() -> Money.from(moneyInput)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NEGATIVE_NUMBER_EXCEPTION.getMessage());
        }

        @ParameterizedTest
        @DisplayName("문자, null, 빈 문자, 공백 포함 문자 입력 시 돈이 생성되지 않는다.")
        @NullAndEmptySource
        @ValueSource(strings = {"ab2d", "   5  00 "})
        void unvalidMoneyInputTest(final String input) {
            // when & then
            assertThatThrownBy(() -> Money.from(input)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NUMBER_FORMAT_EXCEPTION.getMessage());
        }
    }
}
