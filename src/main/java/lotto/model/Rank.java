package lotto.model;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int MatchCount;
    private final int winningMoney;

    Rank(int MatchCount, int winningMoney) {
        this.MatchCount = MatchCount;
        this.winningMoney = winningMoney;
    }

    public int getMatchCount() {
        return MatchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

}

