package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class BuyerTest {
    @Test
    void 입력금액이_1000_단위가_아닌_경우() {
        assertThatThrownBy(() -> new Buyer(7239))
                .isInstanceOf(IllegalArgumentException.class);
    }
}