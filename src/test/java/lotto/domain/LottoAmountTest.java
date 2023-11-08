package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoAmountTest {

    @Test
    void  로또_금액_예외_테스트() {
        assertThatThrownBy(() -> LottoAmount.purchaseAmount(20))
                .isInstanceOf(IllegalArgumentException.class);
    }

}