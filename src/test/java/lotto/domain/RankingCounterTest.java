package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankingCounterTest {

    private RankingCounter rankingCounter;

    @BeforeEach
    void setUp() {
        rankingCounter = new RankingCounter();
    }

    @DisplayName("당첨 카운트를 조절한다.")
    @Test
    void increaseCount() {
        rankingCounter.increaseRankingCount(4);

        Assertions.assertEquals(1, rankingCounter.getCount(Ranking.FOURTH));
    }

    @DisplayName("보너스 넘버가 있을 시 2등의 당첨 카운트를 증카시키고 3등의 당첨카운트를 감소시킨다.")
    @Test
    void calculateWhenRankingHasBonusNumber() {
        rankingCounter.changeCountWhenHasBonusNumber();

        Assertions.assertAll(
                () -> Assertions.assertEquals(1, rankingCounter.getCount(Ranking.SECOND)),
                () -> Assertions.assertEquals(-1, rankingCounter.getCount(Ranking.THIRD))
        );
    }
}
