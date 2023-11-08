package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {
    @Test
    @DisplayName("")
    void test() {
        // given
        Prize none = Prize.NONE;

        // when
        Prize prize = Prize.getPrize(1, false);

        // then
        Assertions.assertEquals(none, prize);
    }
}