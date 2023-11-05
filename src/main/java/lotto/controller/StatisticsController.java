package lotto.controller;

import lotto.domain.lottery.LottoResult;
import lotto.domain.lottery.Lottos;
import lotto.domain.lottery.Prize;

public class StatisticsController {
    private StatisticsController() {
    }

    public static void publishPrizeResult(
            final Lottos lottos,
            final Prize prize
    ) {
        LottoResult lottoResult = LottoResult.of(lottos, prize);
    }
}
