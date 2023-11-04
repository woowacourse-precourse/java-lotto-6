package lotto.dto;

public class Ranking {
    private final int rank;
    private final int matchedWinningNumberAmount;
    private final int matchedBonusNumberAmount;
    private final int rewardMoney;
    private int numberOfWins = 0;

    public Ranking(int rank, int matchedWinningNumberAmount, int matchedBonusNumberAmount, int rewardMoney) {
        this.rank = rank;
        this.matchedWinningNumberAmount = matchedWinningNumberAmount;
        this.matchedBonusNumberAmount = matchedBonusNumberAmount;
        this.rewardMoney = rewardMoney;
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
