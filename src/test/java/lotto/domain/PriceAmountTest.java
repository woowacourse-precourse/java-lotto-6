package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PriceAmountTest {

    @Test
    void 구매금액이_1000원단위가_아니면_에러발생() {
        assertThatThrownBy(() -> new PriceAmount(8001)).isInstanceOf(IllegalArgumentException.class);
    }
}
