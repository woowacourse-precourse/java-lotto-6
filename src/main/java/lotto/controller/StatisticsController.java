package lotto.controller;

import lotto.domain.lottery.Lottos;
import lotto.domain.prize.FinalResults;
import lotto.domain.prize.Prize;
import lotto.domain.prize.PrizeRank;
import lotto.domain.prize.constants.PrizeGrade;

import java.util.List;

public class StatisticsController {
    private StatisticsController() {
    }

    public static void publishPrizeResult(
            final Lottos lottos,
            final Prize prize
    ) {
        PrizeRank matchingResults = lottos.generatePrizeResult(prize);
        List<PrizeGrade> prizeRanks = matchingResults.findPrizeRanks();
        FinalResults finalResults = FinalResults.from(prizeRanks);

        //todo 최종 결과 Dto 출력
    }
}
