package lotto.model;

import static lotto.util.Constants.NUMBERS_SIZE;
import static lotto.util.ExceptionMessage.MATCHING_COUNT_INVALID;

import java.util.List;

public class Result {

    private final int matchingNumber;
    private final boolean isMatchedBonus;

    public Result(int matchingNumber, boolean isMatchedBonus) {
        validateMatchingCount(matchingNumber);
        this.matchingNumber = matchingNumber;
        this.isMatchedBonus = isMatchedBonus;
    }
    
    public Ranking checkRanking() {
        List<Ranking> allRankingCase = Ranking.getAllRankingCase();
        for (Ranking ranking : allRankingCase) {
            if (determineRanking(ranking)) {
                return ranking;
            }
        }
        return Ranking.NOTHING;
    }

    private boolean determineRanking(Ranking ranking) {
        return (ranking.getMatchedCount() == matchingNumber) && (ranking.getHasBonus().contains(isMatchedBonus));
    }

    private void validateMatchingCount(int matchingNumber) {
        if (matchingNumber > NUMBERS_SIZE) {
            throw new IllegalArgumentException(MATCHING_COUNT_INVALID.getMessage());
        }
    }
}
