package lotto.console.game.lotto.domain;

import lotto.console.game.lotto.constants.PrizeRank;

public class PrizeMatchCount {
    int matchCount;
    boolean matchBonus;

    public PrizeMatchCount() {
        matchCount = 0;
        matchBonus = false;
    }

    public void addCount(){
        matchCount++;
    }
    public void matchBonus(){
        matchBonus = true;
    }

    public PrizeRank getPrizeRank() {
        if (matchCount == 6) return PrizeRank.FIRST;
        if (matchCount == 5 && matchBonus) return PrizeRank.SECOND;
        if (matchCount == 5) return PrizeRank.THIRD;
        if (matchCount == 4) return PrizeRank.FOURTH;
        if (matchCount == 3) return PrizeRank.FIFTH;
        return PrizeRank.NONE;
    }
}
