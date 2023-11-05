package lotto.controller;

import lotto.domain.lottery.Lottos;
import lotto.domain.prize.MatchingResults;
import lotto.domain.prize.Prize;

public class StatisticsController {
    private StatisticsController() {
    }

    public static void publishPrizeResult(
            final Lottos lottos,
            final Prize prize
    ) {
        MatchingResults matchingResults = lottos.generatePrizeResult(prize);
        
    }
}
