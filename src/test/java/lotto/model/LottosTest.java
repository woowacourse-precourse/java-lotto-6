package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void from() {
        int quantity = 5;
        Lottos lottos = Lottos.from(quantity);
        assertThat(lottos)
                .isInstanceOf(Lottos.class);
    }
}