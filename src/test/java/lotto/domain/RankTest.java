package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RankTest {
    @DisplayName("등수에 맞는 금액을 제대로 반환한다.")
    @Test
    void getPrizeMoneyByRank() {
        Rank first = Rank.FIRST;

        Integer money = first.getPrizeMoney();

        assertThat(money).isEqualTo(2_000_000_000);
    }
}