package lotto.lotto.domain;

import lotto.domain.Rank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    @DisplayName("1등 당첨 정보를 반환한다.")
    @Test
    void createFirst() {
        Rank rank = Rank.valueOf(6, false);

        Assertions.assertEquals(rank, Rank.FIRST);
    }

    @DisplayName("2등 당첨 정보를 반환한다.")
    @Test
    void createSecond() {
        Rank rank = Rank.valueOf(5, true);

        Assertions.assertEquals(rank, Rank.SECOND);
    }

    @DisplayName("3등 당첨 정보를 반환한다.")
    @Test
    void createThird() {
        Rank rank = Rank.valueOf(5, false);

        Assertions.assertEquals(rank, Rank.THIRD);
    }

    @DisplayName("4등 당첨 정보를 반환한다.")
    @Test
    void createFourth() {
        Rank rank = Rank.valueOf(4, false);

        Assertions.assertEquals(rank, Rank.FOURTH);
    }

    @DisplayName("5등 당첨 정보를 반환한다.")
    @Test
    void createFifth() {
        Rank rank = Rank.valueOf(3, false);

        Assertions.assertEquals(rank, Rank.FIFTH);
    }

    @DisplayName("낙첨 정보를 반환한다.")
    @Test
    void createMiss() {
        Rank rank = Rank.valueOf(0, false);

        Assertions.assertEquals(rank, Rank.MISS);
    }
}