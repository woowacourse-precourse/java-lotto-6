package lotto.model;

public enum Rank {

    FirstPlace(6, false, 2000000000),
    SecondPlace(5, true, 30000000),
    ThirdPlace(5, false, 1500000),
    FourthPlace(4, false, 50000),
    FifthPlace(3, false, 5000);

    final int matchingCount;
    final boolean isBonusNumberMatch; // SecondPlace와 ThirdPlace를 구별하기 위한 변수로, 다른 멤버에게는 의미가 없다.
    final int winningAmount;

    Rank(int matchingCount, boolean isBonusNumberMatch, int winningAmount) {
        this.matchingCount = matchingCount;
        this.isBonusNumberMatch = isBonusNumberMatch;
        this.winningAmount = winningAmount;
    }
}