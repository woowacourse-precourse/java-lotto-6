package lotto.domain.lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 숫자 도메인")
public class LottoNumberTest {
    @DisplayName("숫자 범위는 1~45 까지다.")
    @Nested
    class LottoNumberOutOfRangeTest {
        @DisplayName("숫자 범위가 맞으면 아무 예외를 발생시키지 않는다.")
        @ParameterizedTest(name = "로또 숫자 : {0}")
        @ValueSource(ints = {LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER})
        void Should_DoesNotThrow_When_InRange_MIN_and_MAX(final int numberInRange) {
            // when, then
            assertDoesNotThrow(() -> new LottoNumber(numberInRange));
        }

        @DisplayName("숫자 범위가 아니면 IllegalArgumentException 예외를 발생시킨다.")
        @ParameterizedTest(name = "로또 숫자 : {0}")
        @ValueSource(ints = {LottoNumber.MIN_NUMBER - 1, LottoNumber.MAX_NUMBER + 1})
        void Should_IllegalArgumentExceptionThrown_When_OutOfRange_MIN_and_MAX(final int numberOutOfRange) {
            //when, then
            assertThatThrownBy(() -> new LottoNumber(numberOutOfRange))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }
}
