package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class YieldTest {

    @Test
    void 수익률_계산() {
        Yield yield = new Yield();
        yield.calculateYield(5000, 8000);

        assertThat(yield.getYield()).isEqualTo("62.5");
    }
}