package lotto.controller;

import lotto.domain.lottery.Buyer;
import lotto.domain.lottery.Lottos;
import lotto.domain.prize.FinalResults;
import lotto.domain.prize.Prize;
import lotto.domain.prize.PrizeRank;
import lotto.domain.prize.Revenue;
import lotto.domain.prize.constants.PrizeGrade;
import lotto.dto.FinalResultResponse;
import lotto.view.OutputView;

import java.util.EnumMap;
import java.util.List;

public class StatisticsController {
    private StatisticsController() {
    }

    public static FinalResults getFinalResult(
            final Lottos lottos,
            final Prize prize
    ) {
        PrizeRank matchingResults = lottos.generatePrizeResult(prize);
        List<PrizeGrade> prizeRanks = matchingResults.findPrizeRanks();
        return FinalResults.from(prizeRanks);
    }

    public static void publish(
            final Buyer buyer,
            final FinalResults finalResults
    ) {
        Revenue revenue = Revenue.of(buyer, finalResults);
        EnumMap<PrizeGrade, Integer> prizeGradeCount = finalResults.getPrizeGradeCount();

        FinalResultResponse finalResultResponse = new FinalResultResponse(revenue.getYield(), prizeGradeCount);
        OutputView.printFinalResult(finalResultResponse);
    }
}
