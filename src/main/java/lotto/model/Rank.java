package lotto.model;

public enum Rank {

    FirstPlace(6, false, 2000000000),
    SecondPlace(5, true, 30000000),
    ThirdPlace(5, false, 1500000),
    FourthPlace(4, false, 50000),
    FifthPlace(3, false, 5000);

    final int matchingCount;
    final boolean isBonusNumberMatch;
    final int winningAmount;

    Rank(int matchingCount, boolean isBonusNumberMatch, int winningAmount) {
        this.matchingCount = matchingCount;
        this.isBonusNumberMatch = isBonusNumberMatch;
        this.winningAmount = winningAmount;
    }
}
