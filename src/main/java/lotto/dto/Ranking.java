package lotto.dto;

import lotto.enums.Rank;

public class Ranking {
    private final int rank;
    private final int matchedWinningNumberAmount;
    private final int matchedBonusNumberAmount;
    private final int rewardMoney;
    private int numberOfWins = 0;

    public Ranking(Rank rank) {
        this.rank = rank.getRank();
        this.matchedWinningNumberAmount = rank.getMatchedWinningNumberAmount();
        this.matchedBonusNumberAmount = rank.getMatchedBonusNumberAmount();
        this.rewardMoney = rank.getRewardMoney();
    }

    public void increaseNumberOfWins() {
        numberOfWins++;
    }

    public int getRank() {
        return rank;
    }

    public int getMatchedBonusNumberAmount() {
        return matchedBonusNumberAmount;
    }

    public int getMatchedWinningNumberAmount() {
        return matchedWinningNumberAmount;
    }
    public int getRewardMoney() {
        return rewardMoney;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }
}
