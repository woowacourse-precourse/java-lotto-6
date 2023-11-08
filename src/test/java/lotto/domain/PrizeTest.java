package lotto.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PrizeTest {

    @Test
    void judgeRank() {
        Prize first = Prize.judgeRank(6, false);
        Prize second = Prize.judgeRank(5, true);
        Prize third = Prize.judgeRank(5, false);
        Prize fourth = Prize.judgeRank(4, false);
        Prize fifth = Prize.judgeRank(3, false);
        Prize fail = Prize.judgeRank(2, false);

        assertThat(first).isEqualTo(Prize.FIRST);
        assertThat(second).isEqualTo(Prize.SECOND);
        assertThat(third).isEqualTo(Prize.THIRD);
        assertThat(fourth).isEqualTo(Prize.FOURTH);
        assertThat(fifth).isEqualTo(Prize.FIFTH);
        assertThat(fail).isEqualTo(Prize.FAIL);
    }

}