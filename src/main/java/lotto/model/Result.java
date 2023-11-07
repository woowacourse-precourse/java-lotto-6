package lotto.model;

import java.util.List;

public class Result {

    private final int matchingNumber;
    private final boolean isMatchedBonus;

    public Result(int matchingNumber, boolean isMatchedBonus) {
        this.matchingNumber = matchingNumber;
        this.isMatchedBonus = isMatchedBonus;
    }
    
    public Ranking checkRanking() {
        List<Ranking> allRankingCase = Ranking.getAllRankingCase();
        for(Ranking ranking : allRankingCase) {
            if((ranking.getMatchedCount() == matchingNumber) && (ranking.getHasBonus().contains(isMatchedBonus))) {
                return ranking;
            }
        }
        return Ranking.NOTHING;
    }
}
