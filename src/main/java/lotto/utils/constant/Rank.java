package lotto.utils.constant;

public enum Rank {
    FIRST(6, "2,000,000,000"),
    SECOND(5, "30,000,000"),
    THIRD(5, "1,500,000"),
    FOURTH(4, "50,000"),
    FIFTH(3, "5,000");

    private final int matchNumberCount;
    private final String winningMoney;

    Rank(int matchNumberCount, String winningMoney) {
        this.matchNumberCount = matchNumberCount;
        this.winningMoney = winningMoney;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public String getWinningMoney() {
        return winningMoney;
    }
}
