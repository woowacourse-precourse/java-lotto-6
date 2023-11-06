package lotto;

public enum Result {
    FIRST_PRIZE(6, false, 2_000_000_000),
    SECOND_PRIZE(5, true,30_000_000),
    THIRD_PRIZE(5, false,1_500_000),
    FOURTH_PRIZE(4, false, 50_000),
    FIFTH_PRIZE(3, false,5_000),
    NO_PRIZE(0, false,0);

    private final int matchingNumbers;
    private final int prizeAmount;
    private final boolean bonus;

    Result(int matchingNumbers, boolean bonus, int prizeAmount) {
        this.matchingNumbers = matchingNumbers;
        this.bonus = bonus;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
