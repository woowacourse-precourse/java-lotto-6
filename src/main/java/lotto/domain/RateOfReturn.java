package lotto.domain;

import java.util.Map;

import static constant.MessageList.PERCENTAGE;
import static constant.MessageList.ZERO;

public class RateOfReturn {
    private int prizeMoney;

    public RateOfReturn() {
        prizeMoney = ZERO;
    }

    private int calculatePrizeMoney(Map<Rank, Integer> prizeCount) {
        prizeMoney += prizeCount.get(Rank.FIRST) * Rank.FIRST.prizeMoney;
        prizeMoney += prizeCount.get(Rank.SECOND) * Rank.SECOND.prizeMoney;
        prizeMoney += prizeCount.get(Rank.THIRD) * Rank.THIRD.prizeMoney;
        prizeMoney += prizeCount.get(Rank.FOURTH) * Rank.FOURTH.prizeMoney;
        prizeMoney += prizeCount.get(Rank.FIFTH) * Rank.FIFTH.prizeMoney;

        return prizeMoney;
    }

    public double getRateOfReturn(int purchaseAmount, Map<Rank, Integer> prizeCount) {
        prizeMoney = calculatePrizeMoney(prizeCount);
        return (double) prizeMoney / (double) purchaseAmount * PERCENTAGE;
    }
}
