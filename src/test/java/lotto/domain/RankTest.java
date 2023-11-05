package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RankTest {
    @DisplayName("등수에 맞는 금액을 제대로 반환한다.")
    @Test
    void getPrizeMoneyByRank() {
        Rank first = Rank.FIRST;

        Double money = first.getPrizeMoney();

        assertThat(money).isEqualTo(2_000_000_000.0);
    }

    @DisplayName("주어진 번호 갯수에 따라 상응하는 등수를 반환한다.")
    @Test
    void getRankByWinningNumber() {
        Rank result = Rank.resultRank(6);

        assertThat(result).isEqualTo(Rank.FIRST);
    }
}