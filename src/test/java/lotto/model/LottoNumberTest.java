package lotto.model;

import static lotto.exception.ExceptionMessage.NUMBER_FORMAT_EXCEPTION;
import static lotto.exception.ExceptionMessage.UNVALID_GOAL_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @Test
    @DisplayName("정상적인 값이 주어질 시 생성된다.")
    void validNumberTest() {
        // given
        String numberInput = "30";
        assertDoesNotThrow(() -> LottoNumber.from(numberInput));
    }

    @Nested
    @DisplayName("로또 번호 예외 테스트")
    class BonusNumberExceptionTest {

        @ParameterizedTest
        @DisplayName("문자, null, 빈 문자, 공백 포함 문자가 있으면 안 된다.")
        @NullAndEmptySource
        @ValueSource(strings = {"abc", "   5  00 "})
        void notNumberInputExceptionTest(final String numberInput) {
            // when & then
            assertThatThrownBy(() -> LottoNumber.from(numberInput)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NUMBER_FORMAT_EXCEPTION.getMessage());
        }

        @ParameterizedTest
        @DisplayName("로또 숫자에서 생성될 수 없는 수면 안 된다.")
        @ValueSource(strings = {"100", "-50"})
        void unvalidNumberValueExceptionTest(final String numberInput) {
            // when & then
            assertThatThrownBy(() -> LottoNumber.from(numberInput)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(UNVALID_GOAL_NUMBER.getMessage());
        }
    }
}
