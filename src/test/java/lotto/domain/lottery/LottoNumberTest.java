package lotto.domain.lottery;

import lotto.utils.message.LottoExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    static final int LOWER_BOUND = 0;
    static final int UPPER_BOUND = 46;

    @Test
    @DisplayName("[Edge] 로또 번호가 1 미만")
    void lowerBound() {
        Assertions.assertThatThrownBy(() -> new LottoNumber(LOWER_BOUND))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[Edge] 로또 번호가 45 초과")
    void upperBound() {
        Assertions.assertThatThrownBy(() -> new LottoNumber(UPPER_BOUND))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46, -1, -2})
    @DisplayName("[Exception] 1 ~ 45 범위가 아닐시 예외가 발생한다.")
    void outOfRange(int wrongInput) {
        Assertions.assertThatThrownBy(() -> new LottoNumber(wrongInput))
                .hasMessage(LottoExceptionMessage.NOT_SATISFY_LOTTO_NUMBER_RANGE.getError());
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "45:45", "34:34", "17:17"}, delimiter = ':')
    @DisplayName("[Success] 유효한 범위의 숫자인 경우 해당 숫자의 객체가 생성된다.")
    void outOfRange(int numberInput, int expectedNumber) {
        LottoNumber lottoNumber = new LottoNumber(numberInput);
        Assertions.assertThat(lottoNumber.getNumber()).isSameAs(expectedNumber);
        Assertions.assertThat(lottoNumber).isEqualTo(new LottoNumber(expectedNumber));
    }

}