package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class LottosTest {
    @Test
    void Null값이_들어오면_IAE() {
        assertThrows(IllegalArgumentException.class, () -> new Lottos(null));
    }

}