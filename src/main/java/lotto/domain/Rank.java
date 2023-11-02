package lotto.domain;

public enum Rank {

    FIRST_PLACE(6, false, 2000000000),
    SECOND_PLACE(5, true,30000000),
    THIRD_PLACE(5, false,1500000),
    FOURTH_PLACE(4,false,50000),
    FIFTH_PLACE(3,false,5000),
    NOTHING(0, false, 0);

    private int matchedNumber;
    private boolean hasBonusNumber;
    private int winningPrice;

    Rank(int matchedNumber, boolean hasBonusNumber, int winningPrice) {
        this.matchedNumber = matchedNumber;
        this.hasBonusNumber = hasBonusNumber;
        this.winningPrice = winningPrice;
    }

    public int getMatchedNumber() {
        return matchedNumber;
    }

    public boolean isHasBonusNumber() {
        return hasBonusNumber;
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}
