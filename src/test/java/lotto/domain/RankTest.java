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

    @DisplayName("주어진 번호 갯수가 6이면 1등을 반환한다.")
    @Test
    void getRankFirstByWinningNumber() {
        Rank result = Rank.resultRank(6);

        assertThat(result).isEqualTo(Rank.FIRST);
    }

    @DisplayName("주어진 번호 갯수가 10이면 2등을 반환한다.")
    @Test
    void getRankSecondByWinningNumber() {
        Rank result = Rank.resultRank(10);

        assertThat(result).isEqualTo(Rank.SECOND);
    }

    @DisplayName("주어진 번호 갯수가 5이면 3등을 반환한다.")
    @Test
    void getRankThirdByWinningNumber() {
        Rank result = Rank.resultRank(5);

        assertThat(result).isEqualTo(Rank.THIRD);
    }

    @DisplayName("주어진 번호 갯수가 4이면 4등을 반환한다.")
    @Test
    void getRankFourthByWinningNumber() {
        Rank result = Rank.resultRank(4);

        assertThat(result).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("주어진 번호 갯수가 3이면 5등을 반환한다.")
    @Test
    void getRankFifthByWinningNumber() {
        Rank result = Rank.resultRank(3);

        assertThat(result).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("주어진 번호 갯수가 2이하면 낙첨을 반환한다.")
    @Test
    void getRankLoseByWinningNumber() {
        Rank result = Rank.resultRank(2);

        assertThat(result).isEqualTo(Rank.LOSE);
    }
}