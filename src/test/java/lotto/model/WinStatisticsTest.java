package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinStatisticsTest {

    @Test
    void 발행된_로또_등수별_당첨_갯수로_변환해_저장한다() {
        //given
        List<Ranking> rankings = List.of(Ranking.FIRST, Ranking.SECOND, Ranking.THIRD, Ranking.FOURTH, Ranking.FIFTH, Ranking.NONE);
        //when
        WinStatistics winStatistics = WinStatistics.from(rankings);
        //then
        assertThat(winStatistics.getStatistics())
                .isEqualTo(Map.of(
                        Ranking.FIRST, 1,
                        Ranking.SECOND, 1,
                        Ranking.THIRD, 1,
                        Ranking.FOURTH, 1,
                        Ranking.FIFTH, 1,
                        Ranking.NONE, 1
                ));
    }

    @Test
    void calculateProfit_메서드는_수익률을_계산해_반환한다() {
        //given
        List<Ranking> rankings = List.of(Ranking.FIFTH, Ranking.NONE, Ranking.NONE, Ranking.NONE, Ranking.NONE, Ranking.NONE, Ranking.NONE, Ranking.NONE);
        //when
        WinStatistics winStatistics = WinStatistics.from(rankings);
        double profit = winStatistics.calculateProfit();
        //then
        assertThat(profit).isEqualTo(62.5);
    }
}
