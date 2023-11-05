package lotto.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    private static final String ERROR_PREFIX = "[ERROR] ";

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    void givenOutOfRangeNumber_Then_ExceptionOccurs(final int number) {
        assertThatThrownBy(() -> LottoNumber.of(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    @DisplayName("로또 번호가 1부터 45 사이의 숫자이면 예외가 발생하지 않는다.")
    void givenNumberInRange_Then_NoExceptionOccurs(final int number) {
        assertThatCode(() -> LottoNumber.of(number))
                .doesNotThrowAnyException();
    }
}
