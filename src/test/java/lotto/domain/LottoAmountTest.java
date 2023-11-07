package lotto.domain;

import static lotto.exception.Exception.ONLY_DIVISIBLE_BY_THOUSAND;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoAmountTest {
    @Test
    void 구입_금액이_1000원_단위가_아닌_경우() {
        assertThatThrownBy(() -> new LottoAmount(1001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ONLY_DIVISIBLE_BY_THOUSAND.getMessage());
    }
}
