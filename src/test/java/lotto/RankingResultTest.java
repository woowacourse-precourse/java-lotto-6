package lotto;

import lotto.domain.Ranking;
import lotto.domain.RankingResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankingResultTest {

    @Test
    @DisplayName("결과에 따른 알맞은 수익을 반환한다.")
    void calculateProfit() {
        RankingResult rankingResult = new RankingResult();
        Ranking ranking = Ranking.FIVE_MATCH;

        rankingResult.updateResult(ranking);
        int profit = rankingResult.calculateProfit();

        Assertions.assertEquals(
                profit, Ranking.calculateProfitByRanking(ranking, 1)
        );
    }
}
