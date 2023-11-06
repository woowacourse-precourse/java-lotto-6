package lotto.model;

public enum PrizeMoney {
    PRIZE_FIRST(2000000000, 6, 0),
    PRIZE_SECOND(30000000, 5, 1),
    PRIZE_THIRD(1500000, 5, 0),
    PRIZE_FOURTH(50000, 4, 0),
    PRIZE_FIFTH(5000, 3, 0);

    private final int winningAmount;
    private final int matchingNumbers;
    private final int matchingBonusNumber;

    PrizeMoney(int winningAmount, int matchingNumbers, int matchingBonusNumber) {
        this.winningAmount = winningAmount;
        this.matchingNumbers = matchingNumbers;
        this.matchingBonusNumber = matchingBonusNumber;
    }

}
