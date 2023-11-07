package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    private static final String ERROR_MESSAGE = "[ERROR] ";

    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void givenOutOfRangeNumber_Then_ExceptionOccurs(final int number) {
        assertThatThrownBy(() -> LottoNumber.of(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("로또 번호가 1부터 45 사이의 숫자이면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void givenNumberInRange_Then_NoExceptionOccurs(final int number) {
        assertThatCode(() -> LottoNumber.of(number))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호가 서로 같은 숫자를 가지는 경우 비교 결과는 참이다.")
    @Test
    void givenSameNumber_Then_TrueReturns() {
        final LottoNumber number = LottoNumber.of(1);
        assertThat(number.equals(LottoNumber.of(1))).isTrue();
    }

    @DisplayName("로또 번호가 서로 다른 숫자를 가지는 경우 비교 결과는 거짓이다.")
    @Test
    void givenDifferentNumber_Then_TrueReturns() {
        final LottoNumber number = LottoNumber.of(1);
        assertThat(number.equals(LottoNumber.of(45))).isFalse();
    }
}
