package lotto.validator;

import static lotto.option.Error.NOT_DIVISION_1000;
import static lotto.option.Error.NOT_NEGATIVE_NUMBER;
import static lotto.option.Error.NOT_ZERO;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCountValidatorTest {
    @DisplayName("음수를 입력했을 때 예외가 발생한다.")
    @Test
    void NotPositiveNumberThrowException() {
        //given
        //when
        assertThatThrownBy(() -> LottoCountValidator.check(-1))
                //then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_NEGATIVE_NUMBER.getMessage());
    }

    @DisplayName("0을 입력했을 때 예외가 발생한다.")
    @Test
    void ZeroNumberThrowException() {
        //given
        //when
        assertThatThrownBy(() -> LottoCountValidator.check(0))
                //then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ZERO.getMessage());
    }

    @DisplayName("1000으로 나누어 떨어지지 않는 값을 입력했을 때 예외가 발생한다.")
    @Test
    void NotDivisionNumberThrowException() {
        //given
        //when
        assertThatThrownBy(() -> LottoCountValidator.check(8888))
                //then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_DIVISION_1000.getMessage());
    }
}
