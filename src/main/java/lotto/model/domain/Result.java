package lotto.model.domain;

import static lotto.model.domain.Ranking.*;

import java.util.List;

public class Result {

    private final int matchingNumber;
    private final boolean isMatchedBonus;

    public Result(int matchingNumber, boolean isMatchedBonus) {
        this.matchingNumber = matchingNumber;
        this.isMatchedBonus = isMatchedBonus;
    }

    public int getMatchingNumber() {
        return matchingNumber;
    }

    public boolean getIsMatchedBonus() {
        return isMatchedBonus;
    }

    public Ranking checkRanking() {
        List<Ranking> allRankingCase = getAllRankingCase();
        for(Ranking ranking : allRankingCase) {
            if((ranking.getMatchedCount() == matchingNumber) && (ranking.getHasBonus().contains(isMatchedBonus))) {
                return ranking;
            }
        }
        return NOTHING;
    }
}
