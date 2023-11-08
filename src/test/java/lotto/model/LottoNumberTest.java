package lotto.model;

import lotto.constant.response.Exception;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호의 숫자 범위에 어긋나는 경우 예외를 발생한다.")
    void validRange() {
        Assertions.assertAll(
                () -> assertThatThrownBy(() -> new LottoNumber(0))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(Exception.ERROR_PREFIX.getMessage())
                        .hasMessageContaining(Exception.LOTTO_NUMBER_RANGE.getMessage()),
                () -> assertThatThrownBy(() -> new LottoNumber(46))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(Exception.ERROR_PREFIX.getMessage())
                        .hasMessageContaining(Exception.LOTTO_NUMBER_RANGE.getMessage())
        );
    }

}