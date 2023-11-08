package lotto.utils.constant;

public enum Rank {
    FIRST(6, "2,000,000,000",2000000000),
    SECOND(5, "30,000,000",30000000),
    THIRD(5, "1,500,000",1500000),
    FOURTH(4, "50,000",50000),
    FIFTH(3, "5,000",5000);

    private final int matchNumberCount;
    private final String winningMoney;
    private final int intWinningMoney;

    Rank(int matchNumberCount, String winningMoney, int intWinningMoney) {
        this.matchNumberCount = matchNumberCount;
        this.winningMoney = winningMoney;
        this.intWinningMoney = intWinningMoney;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public String getWinningMoney() {
        return winningMoney;
    }

    public int getIntWinningMoney() {
        return intWinningMoney;
    }
}
