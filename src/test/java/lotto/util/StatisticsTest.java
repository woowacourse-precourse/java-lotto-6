package lotto.util;

import lotto.domain.RankBoard;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StatisticsTest {
    Statistics statistics;

    @BeforeEach
    void beforeEach() {
        statistics = new Statistics();
    }

    @Test
    void 수익률계산테스트() {
        //given
        int buyCount = 8;
        RankBoard board = new RankBoard(0, 0, 0, 0, 1);
        double compareResult = 62.5;
        //when
        double result = statistics.calculateRateOfReturn(buyCount, board);
        //then
        //Assertions.assertThat(result).isEqualTo(compareResult);
        System.out.println(result);
    }
}