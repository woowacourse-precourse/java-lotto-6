package lotto.domain.prize;

import lotto.domain.prize.constants.PrizeGrade;

import java.util.EnumMap;
import java.util.List;

public class FinalResults {
    private EnumMap<PrizeGrade, Long> finalResults;

    public FinalResults(List<PrizeGrade> prizeRanks) {
        EnumMap<PrizeGrade, Long> results = new EnumMap<>(PrizeGrade.class);

        this.finalResults = results;
    }

    public static FinalResults from(List<PrizeGrade> prizeRanks) {
        return new FinalResults(prizeRanks);
    }
}
