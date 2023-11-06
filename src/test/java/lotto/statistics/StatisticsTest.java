package lotto.statistics;

import java.util.List;
import java.util.Map;
import lotto.money.Money;
import lotto.ranking.Ranking;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTest {

    @DisplayName("랭킹 결과를 통해서 통계를 만든다.")
    @Test
    void createStatisticsByRankings() {
        List<Ranking> rankings = List.of(Ranking.FIRST, Ranking.FOURTH, Ranking.FIRST);

        Map<Ranking, Integer> statistics = new Statistics(rankings).getStatistics();

        Assertions.assertAll(
                () -> Assertions.assertEquals(statistics.get(Ranking.FIRST), 2),
                () -> Assertions.assertEquals(statistics.get(Ranking.FOURTH), 1)
        );
    }

    @DisplayName("랭킹 결과를 통해 수익률을 계산한다.")
    @Test
    void calculateProfit() {
        List<Ranking> rankings = List.of(Ranking.FIFTH, Ranking.FOURTH);
        Money money = new Money("2000");

        Statistics statistics = new Statistics(rankings);
        Double profit = statistics.calculateProfit(money);

        Assertions.assertEquals(profit, 2750);
    }
}
