package lotto;

import java.util.HashMap;
import java.util.List;

public enum Ranking {
    FIRST(6,2000000000),
    SECOND(5,30000000),
    THIRD(5,1500000),
    FOURTH(4,50000),
    FIFTH(3,5000),
    NONE(-1,0);

    private final int matchCount;
    private final int reward;
    Ranking(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }
    public static HashMap<Ranking, Integer> getWinningResult(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber){
        HashMap<Ranking, Integer> ranking = new HashMap<>();
        lottos.stream()
                .forEach(lotto -> {
                    boolean matchedBonusNumber = isMatchedBonusNumber(lotto, bonusNumber);
                    Ranking rank = getRanking(getMatchCount(lotto, winningNumbers), matchedBonusNumber);
                    ranking.put(rank, ranking.getOrDefault(rank, 0) + 1);
                });
        return ranking;
    }

    public static Long getMatchCount(Lotto lotto, Lotto winningNumbers){
        return lotto.getNumbers().stream()
                .filter(l -> winningNumbers.getNumbers().contains(l))
                .count();
    }

    public static Ranking getRanking(Long matchCount, boolean isMatchedBonusNumber){
        if(matchCount == FIRST.matchCount)
            return FIRST;
        if(matchCount == SECOND.matchCount && isMatchedBonusNumber)
            return SECOND;
        if(matchCount == THIRD.matchCount)
            return THIRD;
        if(matchCount == FOURTH.matchCount)
            return FOURTH;
        if(matchCount == FIFTH.matchCount)
            return FIFTH;

        return NONE;
    }

    public static boolean isMatchedBonusNumber(Lotto lotto, int bonusNumber){
        return lotto.getNumbers().contains(bonusNumber);
    }

    public int getReward() {
        return reward;
    }
}
