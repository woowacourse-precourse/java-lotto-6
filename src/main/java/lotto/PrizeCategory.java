package lotto;

public enum PrizeCategory {

    MATCHES_THREE(3, 5000),
    MATCHES_FOUR(4, 50000),
    MATCHES_FIVE(5, 1500000),
    MATCHES_FIVE_BONUS(5, 30000000),
    MATCHES_SIX(6, 2000000000);

    private int numberOfMatches;
    private int prizeAmount;

    PrizeCategory(int numberOfMatches, int prizeAmount) {
        this.numberOfMatches = numberOfMatches;
        this.prizeAmount = prizeAmount;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
