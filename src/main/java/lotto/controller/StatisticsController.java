package lotto.controller;

import lotto.domain.lottery.Lottos;
import lotto.domain.lottery.Prize;
import lotto.domain.lottery.PrizeMatchingResult;
import lotto.domain.lottery.PrizeResult;

public class StatisticsController {
    private StatisticsController() {
    }

    public static void publishPrizeResult(
            final Lottos lottos,
            final Prize prize
    ) {
        PrizeMatchingResult lottoMatchingResult = PrizeMatchingResult.of(lottos, prize);
        PrizeResult prizeResults = PrizeResult.from(lottoMatchingResult);
    }
}
