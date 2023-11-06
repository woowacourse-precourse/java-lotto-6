package lotto.service;

import lotto.domain.Ranking;
import lotto.domain.RankingCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCalculatorTest {

    private RankingCounter rankingCounter;

    @BeforeEach
    void setUp() {
        rankingCounter = new RankingCounter();
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void calculatePayOff() {
        rankingCounter.increaseRankingCount(3); //5등
        rankingCounter.increaseRankingCount(4); //4등

        LottoCalculator lottoCalculator = new LottoCalculator(rankingCounter);
        Assertions.assertAll(
                () -> Assertions.assertEquals(110.0, lottoCalculator.calculatePayOff(50000))
        );
    }
}
