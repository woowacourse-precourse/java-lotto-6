package lotto.domain;

public enum WinningMoney {

    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    private long winningMoney;

    WinningMoney(long winningMoney) {
        this.winningMoney = winningMoney;
    }

    public long getWinningMoney() {
        return winningMoney;
    }
}
