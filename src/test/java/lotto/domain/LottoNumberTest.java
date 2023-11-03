package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}