package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    @DisplayName("등수에 맞는 금액을 제대로 반환한다.")
    @Test
    void getPrizeMoneyByRank() {
        Rank first = Rank.FIRST;

        Integer money = first.getPrizeMoney();

        Assertions.assertThat(money).isEqualTo(2_000_000_000);
    }
}