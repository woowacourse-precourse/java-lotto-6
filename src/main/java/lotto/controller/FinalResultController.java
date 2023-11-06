package lotto.controller;

import lotto.domain.lottery.Buyer;
import lotto.domain.lottery.Lottos;
import lotto.domain.prize.FinalResults;
import lotto.domain.prize.Prize;
import lotto.domain.prize.PrizeRank;
import lotto.domain.prize.Revenue;
import lotto.domain.prize.constants.PrizeGrade;
import lotto.dto.FinalResultResponse;

import java.util.List;

public class FinalResultController {
    private FinalResultController() {
    }

    public static FinalResults getFinalResult(
            final Lottos lottos,
            final Prize prize
    ) {
        PrizeRank matchingResults = lottos.generatePrizeResult(prize);
        List<PrizeGrade> prizeRanks = matchingResults.findPrizeRanks();
        return FinalResults.from(prizeRanks);
    }

    public static FinalResultResponse responseFinalResult(
            final Buyer buyer,
            final FinalResults finalResults
    ) {
        Revenue revenue = Revenue.of(buyer, finalResults);
        return new FinalResultResponse(revenue.getYield(), finalResults);
    }
}
