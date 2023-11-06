package lotto.enums;

public enum Rank {
    First(1, 6, 0, 2000000000),
    Second(2, 5, 1, 30000000),
    Third(3, 5, 0, 1500000),
    Fourth(4, 4, 0, 50000),
    Fifth(5, 3, 0, 5000);

    int rank;
    int matchedWinningNumberAmount;
    int matchedBonusNumberAmount;
    int rewardMoney;

    Rank(int rank, int matchedWinningNumberAmount, int matchedBonusNumberAmount, int rewardMoney) {
        this.rank = rank;
        this.matchedWinningNumberAmount = matchedWinningNumberAmount;
        this.matchedBonusNumberAmount = matchedBonusNumberAmount;
        this.rewardMoney = rewardMoney;
    }

    public int getRank() {
        return rank;
    }

    public int getMatchedWinningNumberAmount() {
        return matchedWinningNumberAmount;
    }

    public int getMatchedBonusNumberAmount() {
        return matchedBonusNumberAmount;
    }

    public int getRewardMoney() {
        return rewardMoney;
    }
}
