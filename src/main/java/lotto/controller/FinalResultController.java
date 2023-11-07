package lotto.controller;

import lotto.domain.lottery.Buyer;
import lotto.domain.lottery.Lottos;
import lotto.domain.prize.*;
import lotto.domain.prize.constants.PrizeGrade;
import lotto.dto.FinalResultResponse;
import lotto.service.FinalResultService;

import java.util.EnumMap;
import java.util.List;

public class FinalResultController {
    private FinalResultController() {
    }

    public static FinalResults generateFinalResult(
            final Lottos lottos,
            final Prize prize
    ) {
        List<MatchingResult> matchingResultList = lottos.generateMatchingResultList(prize);
        MatchingResults matchingResults = MatchingResults.from(matchingResultList);

        List<PrizeGrade> prizeGrades = matchingResults.findPrizeGrade();
        EnumMap<PrizeGrade, Integer> results = FinalResultService.generateResult(prizeGrades);
        return FinalResults.from(results);
    }

    public static FinalResultResponse responseFinalResult(
            final Buyer buyer,
            final FinalResults finalResults
    ) {
        Revenue revenue = Revenue.of(buyer, finalResults);
        return new FinalResultResponse(revenue.getYield(), finalResults);
    }
}
