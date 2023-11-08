package lotto.domain;

public enum WinningRule {
    NOTHING(0, 0, "Nothing"),
    FIFTH_PRIZE(3, 5000, "5,000"),
    FOURTH_PRIZE(4, 50000, "50,000"),
    THIRD_PRIZE(5, 1500000, "1,500,000"),
    SECOND_PRIZE(5, 30000000, "30,000,000"),
    FIRST_PRIZE(6, 2000000000, "2,000,000,000");

    private final int matchingNumbers;
    private final int prize;
    private final String convertPrize;

    WinningRule(int matchingNumbers, int prize, String convertPrize) {
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
        this.convertPrize = convertPrize;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public int getPrize() {
        return prize;
    }

    public String getConvertPrize() {
        return convertPrize;
    }
}
