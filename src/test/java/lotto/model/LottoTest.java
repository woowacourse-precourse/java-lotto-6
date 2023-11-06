package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void create() {
        Lotto lotto = Lotto.create();
        assertThat(lotto)
                .isInstanceOf(Lotto.class);
    }
}