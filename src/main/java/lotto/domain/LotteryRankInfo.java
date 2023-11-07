package lotto.domain;

import lotto.enums.RankStandard;

public class LotteryRankInfo {
    private final int rank;
    private final int matchedWinningNumberAmount;
    private final int matchedBonusNumberAmount;
    private final int rewardMoney;
    private int numberOfWins = 0;

    public LotteryRankInfo(RankStandard rankStandard) {
        this.rank = rankStandard.getRank();
        this.matchedWinningNumberAmount = rankStandard.getMatchedWinningNumberAmount();
        this.matchedBonusNumberAmount = rankStandard.getMatchedBonusNumberAmount();
        this.rewardMoney = rankStandard.getRewardMoney();
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
