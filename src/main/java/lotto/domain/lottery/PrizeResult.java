package lotto.domain.lottery;

import lotto.domain.lottery.constants.PrizeRank;

import java.util.EnumMap;
import java.util.List;

public class PrizeResult {
    private final EnumMap<PrizeRank, Long> result;

    private PrizeResult(PrizeMatchingResult lottoMatchingResult) {
        List<Integer> matchingNumberCounts = lottoMatchingResult.getMatchingNumberCounts();
        List<PrizeRank> prizeRanks = generatePrizeRank(matchingNumberCounts);
        result = publishResult(prizeRanks);
    }

    public static List<PrizeRank> generatePrizeRank(List<Integer> matchingNumberCounts) {
        return matchingNumberCounts.stream()
                .map(PrizeRank::findRank)
                .toList();
    }

    public static PrizeResult from(PrizeMatchingResult lottoMatchingResult) {
        return new PrizeResult(lottoMatchingResult);
    }

    private EnumMap<PrizeRank, Long> publishResult(List<PrizeRank> prizeRanks) {
        EnumMap<PrizeRank, Long> prizeRankLongEnumMap = new EnumMap<>(PrizeRank.class);

        return prizeRankLongEnumMap;
    }
}
